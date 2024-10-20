package com.atguigu.cookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("cookie")
@ResponseBody
public class CookieController {



    //先保存cookie到浏览器
    @GetMapping("save")
    public String save(HttpServletResponse response){
        Cookie cookie = new Cookie("JSESSIONID", "root");
        response.addCookie(cookie);
        return "ok";
    }

    //再从浏览器获取cookie
    @GetMapping("data")
    public String data(@CookieValue("JSESSIONID") String cookie) {
        System.out.println("cookie = " + cookie);
        return "cookie = " + cookie;
    }
}
