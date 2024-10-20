package com.atguigu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能：测试拦截器
 */

@RestController
@RequestMapping("order")
public class OrderController {

    @GetMapping("data")
    public String data() {
        System.out.println("data");
        return "ok";
    }

    @GetMapping("data1")
    public String data1() {
        System.out.println("data1");
        return "ok";
    }
}
