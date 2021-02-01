package com.example.springbootdemo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView

@Controller
class RedirectCtl {

    @RequestMapping("/toIndex")
    fun index():String{
        return "/index"
    }

}