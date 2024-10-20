package com.atguigu.requestheader;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("requestheader")
@ResponseBody
public class RequestHeaderController {

    @GetMapping("data")
    public String handle(
            @RequestHeader("Accept-Encoding") String encoding,
            @RequestHeader("Host") String host) {
        System.out.println("encoding = " + encoding + ", host = " + host);
        return "encoding = " + encoding + ", host = " + host;
    }
}
