package com.example.springbootdemo.handler
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.validation.ConstraintViolationException

@ControllerAdvice
class ControllerExceptionHandler {
    private val logger:Logger = LoggerFactory.getLogger("SpringbootDemo")

    /**
     * 全局异常
     */
    @ExceptionHandler(Exception::class)
    fun exceptionHandler (request:HttpServletRequest, ex:Exception) : ModelAndView {
        logger.error("Request URL :{}, Exception:{}", request.requestURI, ex)
        val mv = ModelAndView()
        mv.addObject("url", request.requestURI)
        mv.addObject("exception", ex)
        mv.viewName = "error/error"
        return mv
    }

    /**
     * 参数校验异常
     */
    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.OK)
    fun constraintViolationException(ex:MethodArgumentNotValidException, response: HttpServletResponse):String{
        for (bean in ex.bindingResult.fieldErrors){
            logger.error("错误字段 -> {} 原因 -> {}", bean.field, bean.defaultMessage);
            return "参数校验错误："+bean.defaultMessage
        }
        response.sendError(HttpStatus.BAD_REQUEST.value())
        return "参数校验正确！"
    }
}