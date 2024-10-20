package com.atguigu.json;

import com.atguigu.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("json")
@ResponseBody
public class JsonController {

    @PostMapping("/person")
    /*
        @RequestBody 注解将请求体中的 JSON 数据映射到 Person 类型的 person 参数上
        并将其作为一个对象来传递给 addPerson() 方法进行处理。
     */
    public String addPerson(@RequestBody Person person) {
        System.out.println("person = " + person);
        return person.toString();
    }
}
