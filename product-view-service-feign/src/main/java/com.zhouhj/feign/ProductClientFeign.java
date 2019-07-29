package com.zhouhj.feign;

import com.zhouhj.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;



@FeignClient(value = "PRODUCT-DATA-SERVICE") //此处为eureka中的application名称
public interface ProductClientFeign {

     @GetMapping(value = "/product/getAllproduct")
     List<Product> productList();
}
