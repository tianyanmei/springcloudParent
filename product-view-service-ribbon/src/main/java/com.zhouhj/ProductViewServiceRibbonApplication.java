package com.zhouhj;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ProductViewServiceRibbonApplication {

    public  static  void  main(String [] args){
        int port=8010; //8001，8002，8003.

        if(!NetUtil.isUsableLocalPort(port)){
            System.out.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }

        new SpringApplicationBuilder(ProductViewServiceRibbonApplication.class)
                .properties("server.port="+port).run(args);


    }


    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return  new RestTemplate();
    }


}
