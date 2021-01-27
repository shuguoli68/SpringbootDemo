package com.example.springbootdemo.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class TestCtl {

    @RequestMapping(value = ["/"])
    fun testGet() : String{
        return "Hello , this is a get request ."
    }

    @RequestMapping(value = ["/p"], method = [RequestMethod.POST])
    fun testPost() : String{
        return "Hello , this is a post request ."
    }
}