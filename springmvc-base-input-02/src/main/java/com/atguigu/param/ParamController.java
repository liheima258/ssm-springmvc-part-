package com.atguigu.param;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("param")
public class ParamController {

    /**
     * 情景1 : 直接接值
     *
     * 前端请求: http://localhost:8080/param/value?name=lisi&age=18
     *
     * 可以利用形参列表,直接接收前端传递的param参数!
     *    要求: 1. 参数名 = 形参名
     *         2. 类型相同
     * 不要求一定传参数过来
     */
    @GetMapping(value="/value")
    @ResponseBody
    public String setupForm(String name,int age){
        System.out.println("name = " + name + ", age = " + age);
        return name + age;
    }


    /**
     * 情景2 : @RequestParam注解
     *
     * @RequestParam使用场景：
             * 指定绑定的请求参数名
             * 要求请求参数必须传递（默认情况下，使用此注释的方法参数是必需的，但可以通过将 @RequestParam 注释的 required 标志设置为 false！）
             * 为请求参数提供默认值
     *
     * 前端请求: http://localhost:8080/param/data?name=lisi&stuAge=18
     *
     *  使用@RequestParam注解标记方法的形参
     */
    @GetMapping(value="/data")
    @ResponseBody
    public Object paramForm(@RequestParam("name") String name,
                            @RequestParam(value = "stuAge",required = false,defaultValue = "18") int age){
        System.out.println("name = " + name + ", age = " + age);
        return name+age;
    }


    /**
     * 情景3 ：提交数据的时候一个key对应多个值，我们可以使用集合进行接收！
     *
     * 前端请求: http://localhost:8080/param/mul?hbs=吃&hbs=喝
     *
     *  可以使用集合接收即可!但是需要使用@RequestParam注解指定
     */
    @GetMapping(value="/mul")
    @ResponseBody
    public Object mulForm(@RequestParam List<String> hbs){
        System.out.println("hbs = " + hbs);
        return "success";
    }

    /**
     * 情景4 ：实体接收
     *
     * 前端请求: http://localhost:8080/param/user?name=lisi&age=18
     *
     *  要求属性名必须等于参数名！
     */
    @RequestMapping("/user")
    @ResponseBody
    public String addUser(User user) {
        // 在这里可以使用 user 对象的属性来接收请求参数
        System.out.println("user = " + user);
        return "success";
    }
}