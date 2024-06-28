package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Product;

@Repository
public class ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Product> getAllProducts() {
        return sessionFactory.openSession().createQuery("from Product", Product.class).list();
    }

    @Transactional
    public Product getProductById(Long id) {
        return sessionFactory.openSession().get(Product.class, id);
    }

    @Transactional
    public void saveProduct(Product product) {
        sessionFactory.openSession().saveOrUpdate(product);
    }

    @Transactional
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        if (product != null) {
            sessionFactory.openSession().delete(product);
        }
    }
}
