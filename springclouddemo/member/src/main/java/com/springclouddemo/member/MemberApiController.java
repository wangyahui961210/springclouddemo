package com.springclouddemo.member;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberApiController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/getMember")
    public String getMember(){
        return "this is member!端口号："+serverPort ;
    }
}
