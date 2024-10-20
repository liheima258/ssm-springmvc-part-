package com.atguigu.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @RestControllerAdvice = @ControllerAdvice + @ResponseBody
 * @ControllerAdvice 代表当前类是用于异常处理的controller!
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 当发生空指针异常会触发此方法!
     */
    @ExceptionHandler(NullPointerException.class)
    public Object handlerNullException(NullPointerException e){
        String message = e.getMessage();
        return message;
    }

    /**
     * 所有异常都会触发此方法!但是如果有具体的异常处理Handler,则具体异常处理Handler优先级更高!
     * 例如: 发生NullPointerException异常!
     *       会触发handlerNullException方法,不会触发handlerException方法!
     */
    @ExceptionHandler(Exception.class)
    public Object handlerException(Exception e){
        String message = e.getMessage();
        return message;
    }
}