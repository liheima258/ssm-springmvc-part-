package com.atguigu.api;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api")
@ResponseBody
public class ApiController {
    /**
     * 如果想要获取请求或者响应对象,或者会话等,可以直接在形参列表传入,并且不分先后顺序!
     * 注意: 接收原生对象,并不影响参数接收!
     */
    @GetMapping("data")
    public String api(HttpSession session , HttpServletRequest request,
                      HttpServletResponse response){
        String method = request.getMethod();
        System.out.println("method = " + method);
        return "method = " + method;
    }

    //特殊：获取servletContext对象（应用域对象）
    //解释：springmvc会在初始化容器的时候，会将servletContext对象存储到ioc容器中！
    @Autowired
    private ServletContext servletContext;

    @RequestMapping("/attr/application")
    public String attrApplication() {
        servletContext.setAttribute("appScopeMsg", "i am hungry...");
        return "success";
    }
}
