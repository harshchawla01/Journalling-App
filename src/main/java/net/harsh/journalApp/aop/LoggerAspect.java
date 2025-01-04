package net.harsh.journalApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAspect.class);

    // return type fully qualified class name.method name(args)
    @Before("execution(* net.harsh.journalApp.service.UserService.deleteById(..)) || " +
            "execution(* net.harsh.journalApp.service.UserService.saveEntry(..)) ")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("Method called " + jp.getSignature().getName());
    }

    // @After refers to finally, which will get executed in both cases (throwing and returning) but only after they are run
    @After("execution(* net.harsh.journalApp.service.UserService.deleteById(..)) || " +
            "execution(* net.harsh.journalApp.service.UserService.saveEntry(..)) ")
    public void logMethodExecuted(JoinPoint jp) {
        LOGGER.info("Method executed " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* net.harsh.journalApp.service.UserService.deleteById(..)) || " +
            "execution(* net.harsh.journalApp.service.UserService.saveEntry(..)) ")
    public void logMethodCrash(JoinPoint jp) {
        LOGGER.info("Method has some issues" + jp.getSignature().getName());
    }

    @AfterReturning("execution(* net.harsh.journalApp.service.UserService.deleteById(..)) || " +
            "execution(* net.harsh.journalApp.service.UserService.saveEntry(..)) ")
    public void logMethodExecutedSuccessfully(JoinPoint jp) {
        LOGGER.info("Method executed successfully" + jp.getSignature().getName());
    }

//    join point -> method which is called
//    advice -> the advice methods written above
//    aspect -> we put all advices in a class
//    pointcut -> expression inside "" example-> execution()
//    target object -> the object of the Class whose function in executed
//    proxy -> wraps the target object

}
