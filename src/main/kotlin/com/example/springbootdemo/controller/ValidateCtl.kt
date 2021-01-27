package com.example.springbootdemo.controller

import com.example.springbootdemo.bean.Book
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.validation.Valid

@RestController
class ValidateCtl {

    @RequestMapping(value = ["/book/get"], method = [RequestMethod.POST])
    fun getBook() : Book{
        return Book(
                "1520001",
                "高效率学习方法",
                "李七铭",
                "",
                "wwww.baidu.com",
                "人民出版社",
                "shidj@163.email",
                12345,
                123450,
                1234500,
                Date(),
                Date()
        )
    }

    @RequestMapping(value = ["/book/validate"], method = [RequestMethod.POST])
    fun checkBook(@RequestBody @Valid book: Book) : String{
        return "参数验证成功！"
    }
}