package com.zhouhj.service;

import com.zhouhj.pojo.Product;
import com.zhouhj.ribbon.ProductsClientRibbon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductsClientRibbon productsClientRibbon;

    public List<Product> productList(){
       return  productsClientRibbon.productList();
    }

}
