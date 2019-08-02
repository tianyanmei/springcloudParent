package com.zhouhj.untils;

import cn.hutool.http.HttpUtil;

import java.util.HashMap;

public class FreshConfigUtil {

    public  static  void  main(String[] args){
        HashMap<String,String> header = new HashMap<String, String>();
        header.put("Content-Type","application/json;charset=UTF-8");
        System.out.println("因为要去git获取，还要刷新config-server, 会比较卡，所以一般会要好几秒才能完成，请耐心等待");
        String result = HttpUtil.createPost("http://localhost:8012/actuator/bus-refresh").addHeaders(header).
                execute().body();
        System.out.println("result="+result);
        System.out.println("reflush 完成");


    }

}
