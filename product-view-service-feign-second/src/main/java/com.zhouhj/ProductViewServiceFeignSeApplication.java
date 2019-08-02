package com.zhouhj;

import brave.sampler.Sampler;
import cn.hutool.core.util.NetUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class ProductViewServiceFeignSeApplication {

    public  static  void  main(String [] args){
        int rabbitmqPort=5672;
        if(NetUtil.isUsableLocalPort(rabbitmqPort)){
            System.err.printf("未在端口%d 发现 rabbitMQ服务，请检查rabbitMQ 是否启动", rabbitmqPort);
            System.exit(1);
        }

        int port=8013; //8001，8002，8003.

        if(!NetUtil.isUsableLocalPort(port)){
            System.out.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }

        new SpringApplicationBuilder(ProductViewServiceFeignSeApplication.class)
                .properties("server.port="+port).run(args);


    }


    @Bean
    public Sampler defaultSampler(){
       return Sampler.ALWAYS_SAMPLE;
    }



}
