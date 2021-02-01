package com.example.springbootdemo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletResponse

/**
 * 认证、授权
 * 参考：https://www.jianshu.com/p/defa75b65a46
 */
@RestController
class IndexCtl {

    @GetMapping("")
    fun home(): ModelAndView {
        return ModelAndView("redirect:/toIndex")
    }

}