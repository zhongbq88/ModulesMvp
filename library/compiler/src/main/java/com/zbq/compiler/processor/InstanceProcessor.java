package com.zbq.compiler.processor;


import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import com.zbq.annotation.apt.InstanceFactory;
import com.zbq.annotation.aspect.MemoryCache;
import com.zbq.compiler.AnnotationProcessor;
import com.zbq.compiler.inter.IProcessor;
import com.zbq.compiler.util.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.FilerException;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic;

import static com.squareup.javapoet.TypeSpec.classBuilder;
import static javax.lang.model.element.Modifier.FINAL;
import static javax.lang.model.element.Modifier.PUBLIC;
import static javax.lang.model.element.Modifier.STATIC;

/**
 * Created by zhongbingqi on 2018/3/15.
 */

public class InstanceProcessor implements IProcessor {
    @Override
    public void process(RoundEnvironment roundEnv, AnnotationProcessor mAbstractProcessor) {
        String CLASS_NAME = "InstanceFactory";
        TypeSpec.Builder tb = classBuilder(CLASS_NAME).addModifiers(PUBLIC, FINAL);
        MethodSpec.Builder methodBuilder1 = MethodSpec.methodBuilder("create").addAnnotation(MemoryCache.class)
                .returns(Object.class).addModifiers(PUBLIC, STATIC).addException(IllegalAccessException.class).addException(InstantiationException.class)
                .addParameter(Class.class, "mClass");

        List<ClassName> mList = new ArrayList<>();
        CodeBlock.Builder blockBuilder = CodeBlock.builder();
        blockBuilder.beginControlFlow(" switch (mClass.getSimpleName())");
        try {
            for (TypeElement element : ElementFilter.typesIn(roundEnv.getElementsAnnotatedWith(InstanceFactory.class))) {
                mAbstractProcessor.mMessager.printMessage(Diagnostic.Kind.NOTE,  element.toString());
                if (!Utils.isValidClass(mAbstractProcessor.mMessager, element)) return;
                ClassName currentType = ClassName.get(element);
                if (mList.contains(currentType)) continue;
                mList.add(currentType);
                blockBuilder.addStatement("case $S: return  new $T()", currentType.simpleName(), currentType);
            }
            blockBuilder.addStatement("default: return mClass.newInstance()");
            blockBuilder.endControlFlow();
            methodBuilder1.addCode(blockBuilder.build());
            tb.addMethod(methodBuilder1.build());
            JavaFile javaFile = JavaFile.builder(Utils.PackageName, tb.build()).build();
            javaFile.writeTo(mAbstractProcessor.mFiler);
        } catch (FilerException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
