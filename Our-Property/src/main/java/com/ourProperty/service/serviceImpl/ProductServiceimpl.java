package com.ourProperty.service.serviceImpl;


import com.ourProperty.entity.Product;
import com.ourProperty.repository.ProductRepository;
import com.ourProperty.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceimpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getAllProducts(){
        List<Product> productList = repository.findAll();
        return productList;

    }
}
