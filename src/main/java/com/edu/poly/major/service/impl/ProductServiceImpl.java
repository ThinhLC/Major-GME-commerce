package com.edu.poly.major.service.impl;

import com.edu.poly.major.model.Product;
import com.edu.poly.major.repository.ProductRepository;
import com.edu.poly.major.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }//findAll

    public void updateProduct(Product product) {
        productRepository.save(product);
    }//add or update (tuy vao pri-key)

    public void removeProductById(long id) {
        productRepository.deleteById(id);
    }//delete dua vao pri-key

    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }//search theo id

    public List<Product> getAllProductByCategoryId(int id) {
        return productRepository.findAllByCategory_Id(id);
    }
    //findList theo ProductDTO.categoryId

}
