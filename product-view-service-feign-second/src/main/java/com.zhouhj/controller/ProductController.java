package com.zhouhj.controller;

import com.zhouhj.pojo.Product;
import com.zhouhj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

     @Autowired
     ProductService ProductService;

    @Value("${version}")
    String version;
     @RequestMapping(value = "/product")
    public List<Product> productList(){
         System.out.println("-----------------"+version);
        return ProductService.productList();
    }
}
