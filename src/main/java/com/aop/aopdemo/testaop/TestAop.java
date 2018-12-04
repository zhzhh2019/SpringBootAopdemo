package com.aop.aopdemo.testaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @Description:
 * @author zzh
 * @since: 2018/12/4 10:49
 */
@Aspect
@Component
public class TestAop {
    //使用org.slf4j.Logger,这是Spring实现日志的方法
    private final static Logger logger = LoggerFactory.getLogger(TestAop.class);

    /**
    * @Description:定义AOP扫描路径,第一个注解只扫描aopTest方法
    * @auther: zzh
    * @date:  10:53  2018/12/4
    * @param: 
    * @return: 
    */
    @Pointcut("execution(public * com.aop.aopdemo.controller.TesrAopController.*())")
    public void log(){}
    /**
     * 记录HTTP请求开始时的日志
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //URL
        logger.info("url={}", request.getRequestURI());
        //method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class={} and method name = {}",joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName());
        //参数
        logger.info("参数={}",joinPoint.getArgs());
    }
    /**
     * 记录HTTP请求结束时的日志
     */
    @After("log()")
    public void doAfter(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url = {} end of execution", request.getRequestURL());
    }


}
