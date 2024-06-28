package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProductDAO;
import com.model.Product;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public Product getProductById(Long id) {
        return productDAO.getProductById(id);
    }

    public void saveProduct(Product product) {
        productDAO.saveProduct(product);
    }

    public void deleteProduct(Long id) {
        productDAO.deleteProduct(id);
    }
}
