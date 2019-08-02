package com.zhouhj.feign;

import com.zhouhj.pojo.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductClientFeignImpl implements  ProductClientFeign {
    @Override
    public List<Product> productList() {
        List list = new ArrayList();
        list.add(new Product(0,"产品数据微服务不可用",0));
        return list;
    }
}
