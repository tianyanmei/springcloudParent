package com.zhouhj;

import brave.sampler.Sampler;
import cn.hutool.core.util.NetUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class ProductViewServiceFeignApplication {

    public  static  void  main(String [] args){
        int port=8012; //8001，8002，8003.

        if(!NetUtil.isUsableLocalPort(port)){
            System.out.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }

        new SpringApplicationBuilder(ProductViewServiceFeignApplication.class)
                .properties("server.port="+port).run(args);


    }


    @Bean
    public Sampler defaultSampler(){
       return Sampler.ALWAYS_SAMPLE;
    }



}
