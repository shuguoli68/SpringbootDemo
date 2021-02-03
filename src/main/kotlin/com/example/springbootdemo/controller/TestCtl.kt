package com.example.springbootdemo.controller

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * 测试接口
 */
@RestController
class TestCtl {

    @RequestMapping(value = ["/test"])
    fun testGet() : String{
        return "Hello , this is a get request ."
    }

    @RequestMapping(value = ["/test/input/{input}"])
    fun testInput(@PathVariable input:String) : String{
        return "Hello , $input ."
    }

    @RequestMapping(value = ["/test/post"], method = [RequestMethod.POST])
    fun testPost() : String{
        return "Hello , this is a post request ."
    }
}