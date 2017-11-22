package com.wyl.springbootlearning.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * <h2>AOP test
 *
 * @author WYL
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

//    @Before("execution(public * com.wyl.springbootlearning.controller.UserController.*(..))")
//    public void logBefore() {
//        logger.info("logBefore: UserController");
//    }
//
//    @After("execution(public * com.wyl.springbootlearning.controller.UserController.*(..))")
//    public void logAfter() {
//        logger.info("logAfter: UserController");
//    }

    /**
     * 定义切入点
     */
    @Pointcut("execution(public * com.wyl.springbootlearning.controller.UserController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        logger.info("url={}", attributes.getRequest().getRequestURL());
        logger.info("ip={}", attributes.getRequest().getRemoteHost());
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        logger.info("logAfter: UserController");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object);
    }
}
