package com.example.springbootdemo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class RedirectCtl {

    @RequestMapping("/toIndex")
    fun index():String{
        return "/index"
    }

    @RequestMapping("/toLogin")
    fun login(): String? {
        return "/login_page"
    }
}