package io.github.snyh005.multibank.service;

import io.github.snyh005.multibank.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getProduct(Integer id);

    void deleteProduct(Integer id);

    Product editProduct(Integer id,String name, String description, Long price ) throws Exception;
}
