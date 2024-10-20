package com.atguigu.jsp;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("jsp")
public class JspController {

     /*
        在SpringMVC中，通过返回值来实现快速转发 ==> 跳转到其他页面
        也可以使用 redirect（重定向）关键字 或者 forward（转发）关键字  ==> 跳转到项目下的资源
     */

    /**
     *  跳转到其他页面
     *
     *  如果要返回jsp页面:
     *     1.方法返回值改成字符串类型
     *     2.返回逻辑视图名（页面名）即可
     *     3.不能加 @ResponseBody (加了就代表直接返回数据到客户端，而不是跳转到其他页面)
     */
    @GetMapping("jump")
    public String jumpJsp(HttpServletRequest request){
        System.out.println("FileController.jumpJsp");
        request.setAttribute("msg","request data!!");
        return "home";
    }

    /**
     * 跳转到项目下的资源
     *
     * 注意： 转发和重定向到项目下资源路径都是相同，都不需要添加项目根路径！填写项目下路径即可！
     */

    @RequestMapping("/redirect-demo")
    public String redirectDemo() {
        System.out.println("FileController.jumpJsp");
        // 重定向到 /jsp/jump 路径
        return "redirect:/jsp/jump";
    }

    @RequestMapping("/forward-demo")
    public String forwardDemo() {
        System.out.println("FileController.jumpJsp");
        // 转发到 /jsp/jump 路径
        return "forward:/jsp/jump";
    }
}
