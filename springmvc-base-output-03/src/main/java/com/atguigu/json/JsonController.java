package com.atguigu.json;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("json")
@ResponseBody
public class JsonController {

    //  1.返回单个对象
    @GetMapping("user")
    public User showUser() {
        User user = new User();
        user.setAge(18);
        user.setName("John");
        //返回的对象,会使用jackson的序列化工具,转成json返回给前端!
        return user;
    }

    //  2.返回多个对象（集合）
    @GetMapping("user2")
    public List<User> showUser2() {
        User user = new User();
        user.setAge(18);
        user.setName("John");
        List<User> list =new ArrayList<>();
        list.add(user);
        return list;
    }
}
