package Listeners;

import Retry.RetryFailedTestCases;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author: Akhilesh Maloo
 * @date: 2/4/18.
 */
public class RetryListener implements IAnnotationTransformer {


    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {

        IRetryAnalyzer retry = iTestAnnotation.getRetryAnalyzer();

        if(retry == null)
            iTestAnnotation.setRetryAnalyzer(RetryFailedTestCases.class);
    }
}

