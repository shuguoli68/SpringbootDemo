package com.example.springbootdemo.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        //uper.configure(http)
        if(http == null){
            return
        }
        http
                .authorizeRequests()     // 对请求进行验证
                .antMatchers("/test/**").permitAll()//无需权限访问
                .antMatchers("/admin/**").hasRole("R_ADMIN")     // 必须有ADMIN权限
                .antMatchers("/user/**").hasAnyRole("R_USER", "R_ADMIN")       //有任意一种权限
                .anyRequest()     //任意请求（这里主要指方法）
                .authenticated()   // 需要身份认证
                .and()   //表示一个配置的结束

                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/form")
                .defaultSuccessUrl("/index.html") //成功登陆后跳转页面
                .failureUrl("/login_error.html")
                .permitAll()
                .and()

                .logout().permitAll()  //开启SpringSecurity内置的退出登录，会为我们提供一个/logout接口
                .and()
                .csrf().disable();    //关闭csrf跨站伪造请求
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        //super.configure(auth)
        if (auth == null){
            return
        }
        //在内存中配置用户
        auth.inMemoryAuthentication()
                .withUser("shu")
                .password("123")
                .roles("R_USER")
                .and()
    }

    override fun configure(web: WebSecurity?) {
        //super.configure(web)
        if (web == null){
            return
        }
        //放行这些路径下的静态资源
        web
                .ignoring()
                .antMatchers("/js/**", "/css/**","/images/**")
    }

}