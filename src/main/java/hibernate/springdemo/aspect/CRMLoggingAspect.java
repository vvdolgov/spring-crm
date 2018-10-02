package hibernate.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* hibernate.springdemo.controller.*.*(..))")
    public void forControllerPackage(){}

    @Pointcut("execution(* hibernate.springdemo.service.*.*(..))")
    public void forServicePackage(){}

    @Pointcut("execution(* hibernate.springdemo.dao.*.*(..))")
    public void forDAOPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    public void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint point){
        String method = point.getSignature().toShortString();
        logger.info("\n=====>>> in @Before: calling method: "+method);

        Object[] args = point.getArgs();

        for(Object arg : args){
            logger.info("\n=====>>> argument: " + arg);
        }
    }

    @AfterReturning(returning = "result", pointcut = "forAppFlow()")
    public void afterReturning(JoinPoint point, Object result){
        String method = point.getSignature().toShortString();
        logger.info("\n=====>>> in @AfterReturning: calling method: "+method);

        logger. info("\n=====>>> result: " + result);
    }
}
