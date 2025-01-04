package net.harsh.journalApp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* net.harsh.journalApp.service.UserService.saveEntry(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint joinPoint, int postId) throws Throwable {

        // Just an example
        // Not used in this application
        if(postId < 0) {
            LOGGER.info("PostId is negative, updating it. ");
            postId = -postId;
            LOGGER.info("new value" + postId);
        }

        Object obj = joinPoint.proceed(new Object[]{postId});
        return obj;
    }
}
