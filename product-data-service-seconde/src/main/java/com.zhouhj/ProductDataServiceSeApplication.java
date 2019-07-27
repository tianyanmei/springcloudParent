package com.zhouhj;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.validation.constraints.Future;

@SpringBootApplication
@EnableEurekaClient
public class ProductDataServiceSeApplication {

    public  static  void  main(String [] args){
        int port=8002; //8001，8002，8003.

        if(!NetUtil.isUsableLocalPort(port)){
            System.out.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }

        new SpringApplicationBuilder(ProductDataServiceSeApplication.class)
                .properties("server.port="+port).run(args);


    }


}
