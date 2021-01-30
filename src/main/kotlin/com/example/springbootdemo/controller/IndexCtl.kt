package com.example.springbootdemo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

/**
 * 认证、授权
 * 参考：https://www.jianshu.com/p/defa75b65a46
 */
@RestController
class IndexCtl {

    @GetMapping("")
    fun home(response: HttpServletResponse){
        //内部重定向
        response.sendRedirect("/index")
    }

    @RequestMapping("/index")
    @ResponseBody
    fun index():String{
        return "index"
    }
}