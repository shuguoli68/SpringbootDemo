package com.example.springbootdemo.controller

import com.example.springbootdemo.bean.Book
import com.example.springbootdemo.bean.UserBean
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.validation.Valid

/**
 * 参数校验valid
 */
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

    @RequestMapping(value = ["/book/valid"], method = [RequestMethod.POST])
    fun checkBook(@Valid @RequestBody book: Book) : String{
        return "参数验证成功！"
    }

    @RequestMapping(value = ["/user/get"], method = [RequestMethod.POST])
    fun getUser() : UserBean{
        val userBean = UserBean()
        userBean.userId = 1001
        userBean.account = "jud8394"
        userBean.userName = "liming"
        userBean.password = "123456"
        return userBean
    }

    @RequestMapping(value = ["/user/valid"], method = [RequestMethod.POST])
    fun checkUser(@Valid @RequestBody userBean: UserBean) : String{
        return "参数验证成功！"
    }
}