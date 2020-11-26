package com.springclouddemo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {
    /**
     * 在springcloud中有两种方式 rest、fegin（springcloud）
     */
    @Autowired
    private RestTemplate restTemplate;//由springboot web组件提供 默认整合了ribbon负载均衡器
    //rest底层是采用httpClient技术
    //订单服务调用会员服务
    @RequestMapping("/getOrder")
    public String getOrder(){
        //有两种方式一种是服务别名方式调用 一种是直接调用 使用别名去注册中心上获取对应的服务调用地址
        String url="http://app-itmayiedu-member/getMember";
        String result=restTemplate.getForObject(url,String.class);
        System.out.println("订单服务调用会员服务result:"+result);
        return  result;
    }
}
