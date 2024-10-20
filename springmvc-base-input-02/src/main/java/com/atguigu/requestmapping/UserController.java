package com.atguigu.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

    /**
     * 精准设置访问地址 /user/login
     * 默认情况下：@RequestMapping("/login") 任何请求方式都可以访问！
     * @RequestMapping(value = "login",method = RequestMethod.GET) 指定前端请求只能为GET请求
     * 注意:违背请求方式会出现405异常!
     * @RequestMapping(value="/login",method=RequestMethod.GET)
     * ||
     * @GetMapping(value="/login")
     * 同理还有
         @PostMapping
         @PutMapping
         @DeleteMapping
         @PatchMapping
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    @ResponseBody
    public String login(){
        System.out.println("UserController.login");
        return "login success!!";
    }

    /**
     * 精准设置访问地址 /user/register
     */
    @RequestMapping("register")
    @ResponseBody
    public String register(){
        System.out.println("UserController.register");
        return "register success!!";
    }
    
}
