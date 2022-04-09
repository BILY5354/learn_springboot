package com.itheima.controller.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *  作为springmvc的异常处理器
 * @author CDUY
 * @version 1.0
 */
//@ControllerAdvice
@RestControllerAdvice
public class ProjectExceptionAdvice {
    //拦截所有的异常消息
    @ExceptionHandler
    public R doException(Exception ex) {
        //记录日志
        //通知运维
        //通知开发
        ex.printStackTrace();//记得打印异常
        return new R("服务器故障请稍后再试");
    }
}
