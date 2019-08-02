package com.zhouhj;

import cn.hutool.core.util.NetUtil;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.HystrixMetricsProperties;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletRegistration;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApplication {

    public static  void  main(String[] args){

        int port=8020;
        if(!NetUtil.isUsableLocalPort(port)){
            System.out.printf("该端口%d已经被占用",port);
            System.exit(1);
        }

        new SpringApplicationBuilder(HystrixDashboardApplication.class).
                properties("server.port="+port).run(args);

    }

   /* @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet =new
                HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return  registrationBean;
    }*/





}
