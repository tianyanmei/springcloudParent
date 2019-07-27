package com.zhouhj.controller;

import com.zhouhj.pojo.Product;
import com.zhouhj.server.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

     @Autowired
    ProductServiceImpl productService;

     @RequestMapping(value = "/getAllproduct")
    public List<Product> productList(){
        return productService.productList();
    }
}
