package com.zhouhj.service;

import com.zhouhj.feign.ProductClientFeign;
import com.zhouhj.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductClientFeign productClientFeign;
    public List<Product> productList(){
       return  productClientFeign.productList();
    }

}
