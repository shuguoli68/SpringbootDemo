package com.example.springbootdemo.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * 测试接口
 */
@Api(value = "/Test", tags = arrayOf("测试接口"))
@RestController
class TestCtl {

    @ApiOperation(value = "测试接口test")
    @RequestMapping(value = ["/test"])
    fun testGet() : String{
        return "Hello , this is a get request ."
    }

    @ApiOperation(value = "测试接口,返回输入数据")
    @RequestMapping(value = ["/test/input/{input}"])
    fun testInput(@PathVariable input:String) : String{
        return "Hello , $input ."
    }

    @ApiOperation(value = "测试post接口")
    @RequestMapping(value = ["/test/post"], method = [RequestMethod.POST])
    fun testPost() : String{
        return "Hello , this is a post request ."
    }
}