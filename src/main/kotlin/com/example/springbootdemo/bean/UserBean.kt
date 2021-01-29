package com.example.springbootdemo.bean

import org.hibernate.validator.constraints.Length
import java.io.Serializable
import javax.validation.constraints.NotNull

class UserBean : Serializable {
    var userId: Long? = null
    var userName: @NotNull @Length(min = 2, max = 10) String? = null
    var account: @NotNull @Length(min = 6, max = 20) String? = null
    var password: @NotNull @Length(min = 6, max = 20,message = "密码6~20") String? = null

}