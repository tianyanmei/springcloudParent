package com.zhouhj.ribbon;


import com.zhouhj.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ProductsClientRibbon {

    @Autowired
    RestTemplate restTemplate;

    public List<Product> productList(){

        return  restTemplate.getForObject("http://product-data-service/product/getAllproduct",List.class);
    }


}
