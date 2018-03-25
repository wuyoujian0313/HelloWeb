package com.ai.web;


import com.ai.web.annotation.ControllerEx;
import com.ai.web.annotation.RequestMappingEx;
import com.ai.web.annotation.View;

@ControllerEx
public class TestControlAnnotation {

    //使用RequestMapping注解指明forward1方法的访问路径
    @RequestMappingEx("control")
    public View forward1() {
        //执行完forward1方法之后返回的视图
        return new View("/control.jsp");
    }
}
