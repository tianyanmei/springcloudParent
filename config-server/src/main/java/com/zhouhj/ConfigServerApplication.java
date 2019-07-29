package com.zhouhj;

import cn.hutool.core.util.NetUtil;
import org.hibernate.validator.cfg.context.PropertyTarget;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableConfigServer
public class ConfigServerApplication {

    public  static  void  main(String [] args){
        int port =8030;
        if(!NetUtil.isUsableLocalPort(port)){
            System.out.printf("端口%d被占用了，无法启动%n",port);
            System.exit(1);
        }

        new SpringApplicationBuilder(ConfigServerApplication.class).
                properties("server.port="+port).run(args);
    }

}
