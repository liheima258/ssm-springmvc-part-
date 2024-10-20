package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能：测试全局异常处理 + 参数校验
 */

@RestController
@RequestMapping("user")
public class UserController {

    //测试空指针异常处理
    @GetMapping("data")
    public String data() {
        String s = null;
        s.toString();
        return "ok";
    }

    //测试除零异常处理
    @GetMapping("data1")
    public String data1() {
        int i = 1 / 0;
        return "ok";
    }

    /**
     * @Validated 代表应用校验注解! 必须添加!
     * 别忘了加 @RequestBody
     */
    @PostMapping("save")
    public Object save(@Validated @RequestBody User user,
                       //在实体类参数和 BindingResult 之间不能有任何其他参数, BindingResult可以接受错误信息,避免信息抛出!
                       BindingResult result){
        //判断是否有信息绑定错误! 有可以自行处理!
        if (result.hasErrors()){
            System.out.println("错误");
            Map map = new HashMap<>();
            map.put("code",400);
            map.put("msg","错误");
            return map;
        }
        //没有,正常处理业务即可
        System.out.println("正常");
        return user;
    }
}
