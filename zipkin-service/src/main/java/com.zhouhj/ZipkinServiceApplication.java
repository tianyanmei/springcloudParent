package com.zhouhj;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import zipkin.server.internal.EnableZipkinServer;


@EnableZipkinServer
@SpringBootApplication
public class ZipkinServiceApplication {

    public  static  void  main(String[] args){
        int port =9411;

        if(!NetUtil.isUsableLocalPort(port)){
            System.out.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }

        new SpringApplicationBuilder(ZipkinServiceApplication.class).
                properties("server.port="+port).run(args);

    }
}
