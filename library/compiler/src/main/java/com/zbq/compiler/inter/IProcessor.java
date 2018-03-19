package com.zbq.compiler.inter;


import com.zbq.compiler.AnnotationProcessor;

import javax.annotation.processing.RoundEnvironment;

/**
 * Created by zhongbingqi on 2018/3/15.
 */

public interface IProcessor {
    void process(RoundEnvironment roundEnv, AnnotationProcessor mAbstractProcessor);
}
