package com.atguigu.path;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("path")
@ResponseBody
public class PathController {

    /**
     * 动态路径设计: /path/{动态部分}/{动态部分}   动态部分使用{}包含即可! {}内部动态标识!
     * 形参列表取值:  @PathVariable int id             如果形参名  = {动态标识} 自动赋值!
     *             @PathVariable("动态标识") int id   如果形参名 != {动态标识} 可以通过指定动态标识赋值!
     *
     * 访问测试:  /path/1/root  -> id = 1  uname = root
     */
    @GetMapping("{id}/{name}")
    public String getUser(@PathVariable int id,
                          @PathVariable("name") String uname) {
        System.out.println("id = " + id + ", uname = " + uname);
        return "user_detail";
    }
}
