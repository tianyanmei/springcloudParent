package com.zhouhj;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class TurbineApplication {

    public static  void  main(String[] args){

        int port =8021;
        if(!NetUtil.isUsableLocalPort(port)){
            System.out.printf("该端口号%d已经被占用",port);
            System.exit(1);
        }

        new SpringApplicationBuilder(TurbineApplication.class).
                properties("server.port="+port).run(args);

    }
}
