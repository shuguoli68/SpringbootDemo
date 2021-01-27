package com.example.springbootdemo.controller

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class TestCtl {

    @RequestMapping(value = ["/"])
    fun testGet() : String{
        return "Hello , this is a get request ."
    }

    @RequestMapping(value = ["/input/{input}"])
    fun testInput(@PathVariable input:String) : String{
        return "Hello , $input ."
    }

    @RequestMapping(value = ["/p"], method = [RequestMethod.POST])
    fun testPost() : String{
        return "Hello , this is a post request ."
    }
}