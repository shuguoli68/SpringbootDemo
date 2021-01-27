package com.example.springbootdemo.util

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.*
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.util.*

@Aspect
@Component
class LogAspect {
    private val logger = LoggerFactory.getLogger(this::class.java)

    /**
     * 拦截切点
     */
    @Pointcut("execution(* com.example.springbootdemo.controller..*Ctl.*(..))")
    fun log(){

    }

    /**
     * 前置通知，在方法之前通知
     */
    @Before("log()")
    fun doBefore(joinPoint: JoinPoint){
        logger.info("---------doBefore---------")
        // 接收到请求，记录请求内容
        val attributes = RequestContextHolder.getRequestAttributes() as ServletRequestAttributes? ?: return
        val request = attributes.request
        println()
        logger.info("--------------->日志打印ing<------------- : ")
        logger.info("---->请求URL : " + request.requestURL.toString())
        logger.info("---->HTTP方法 : " + request.method)
        logger.info("---->IP : " + request.remoteAddr)
        logger.info("---->方法名 : " + joinPoint.signature.declaringTypeName.toString() + "." + joinPoint.signature.name)
        logger.info("---->参数值 : " + Arrays.toString(joinPoint.args))
    }

    /**
     * 返回结果的通知
     */
    @AfterReturning(returning = "result", pointcut = "log()")
    fun doAfterReturn(result:Any){
        logger.info("--------------->日志打印ing<------------- : ")
        logger.info("---->返回体 : $result")
        println()
    }

    /**
     * 异常
     */
    @AfterThrowing(throwing = "result", pointcut = "log()")
    fun doAfterException(result:Throwable){
        logger.info("--------------->日志打印ing<------------- : ")
        logger.info("---->异常 : ${result.message}")
        println()
    }

    class RequestLog{

        var url:String = ""
        var ip:String = ""
        var classMethod:String = ""
        var args = arrayOfNulls<Any>(1)

        constructor(url: String, ip: String, classMethod: String, args: Array<Any?>) {
            this.url = url
            this.ip = ip
            this.classMethod = classMethod
            this.args = args
        }
    }
}