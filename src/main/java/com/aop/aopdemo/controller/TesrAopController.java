package com.aop.aopdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzh
 * @Description:
 * @since: 2018/12/4 10:46
 */
@RestController
public class TesrAopController {
    @RequestMapping(value = "/testaop")
    public String testAop(){
        return "test aop";
    }

    @RequestMapping(value = "/testaop3")
    public String testAop1(String name){
        return "test aop4";
    }

}
