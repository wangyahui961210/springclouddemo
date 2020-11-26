package com.springclouddemo.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
        //如果以rest方式以别名方式进行调用 需要依赖ribbon负载均衡器
    }

    //解决restTemplate模板找不到原因 需要注册到springboot容器中@bean
    //@LoadBalanced就能让这个RestTemplate在请求时拥有客户端负载均衡的能力
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
