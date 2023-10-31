package com.cycbersoft.demospringboot03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
*   Để định nghĩa đường dẫn, có 2 annatation:
*       @Controller: Khi url có nội dung trả ra là 1 file html
*       @ResponseBody: Giúp @Controller có thể trả ra data kiểu String để viết API
*
*   @Restcontroller: Là sự kết hợp của @Controller và @ResponseBody => Viết API
* */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("")
    public String hello(){
        return "Hello SpringBoot";
    }

    @GetMapping("/cycbersoft")
    public String helloCycbersoft(){
        return "Hello Cycbersoft";
    }


}
