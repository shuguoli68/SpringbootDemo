package com.example.springbootdemo.bean

import org.hibernate.validator.constraints.Length
import java.util.*
import javax.validation.constraints.*

data class Book (
        @NotBlank(message = "书的唯一ID不能为空")
        var id:String,
        @NotBlank(message = "书名不能为空")
        @Length(message = "书名长度必须大于1且小于50", min = 1, max = 50)
        var name:String,
        @NotBlank(message = "作者不能为空")
        var author:String,
        var description:String,
        var url:String,
        @NotBlank(message = "出版社不能为空")
        var press:String,
        @Email(message = "邮箱格式不正确")
        var email:String,
        @Max(value = 1000, message = "章节必须小于1000")
        @Min(value = 1, message = "章节必须大于1")
        var chapter:Long,
        @Max(value = 10000, message = "页数必须小于10000")
        @Min(value = 1, message = "页数必须大于1")
        var pages:Long,
        @Max(value = 1000 * 10000, message = "字数必须小于1000万")
        @Min(value = 10, message = "字数必须大于10")
        var words:Long,
        @Future()
        var create_time:Date,
        var update_time:Date
)