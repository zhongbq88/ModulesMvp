package com.zbq.compiler;

import com.google.auto.service.AutoService;
import com.zbq.annotation.apt.InstanceFactory;
import com.zbq.compiler.processor.InstanceProcessor;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;

/**
 * Created by zhongbingqi on 2018/3/15.
 */

@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("com.zbq.annotation.apt.InstanceFactory")
public class AnnotationProcessor extends AbstractProcessor {
    public Filer mFiler;
    public Elements mElements;
    public Messager mMessager;

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        mMessager.printMessage(Diagnostic.Kind.NOTE,"AnnotationProcessor getSupportedAnnotationTypes ");
        Set<String> types=new LinkedHashSet<>();
        types.add(InstanceFactory.class.getCanonicalName());
        return types;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        mFiler = processingEnv.getFiler();
        mElements = processingEnv.getElementUtils();
        mMessager = processingEnv.getMessager();
        mMessager.printMessage(Diagnostic.Kind.NOTE,"AnnotationProcessor process ");
        new InstanceProcessor().process(roundEnv, this);
        return true;
    }
}
