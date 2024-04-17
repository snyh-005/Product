package io.github.snyh005.multibank.service.impl;

import io.github.snyh005.multibank.model.Product;
import io.github.snyh005.multibank.service.ProductService;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    /*
    A single copy of the product is created and any changes made by a single thread will be
     notified to the other to avoid concurrency issues
     */
    public static volatile Map<Integer, Product> products = new HashMap<>();


    /*
     Add a new product to the list
     */
    public Product createProduct(Product product){
        //TO Do: validations to be added
        product.setId(products.size()+1);
        products.put(products.size()+1, product);
        return product;
    }


    /*
     * Return product with id, if not found return null
     */
    public List<Product> getProduct(Integer id){
        if( null != id) {
            return Arrays.asList(products.getOrDefault(id, null));
        }
        return products.values().stream().toList();
    }

    /*
     Delete a product with the id
     */
    public void deleteProduct(Integer id){
        products.remove(id);
    }

    /*
    Edit a product name / description / price with the id
     */
    public Product editProduct(Integer id,String name, String description, Long price ) throws Exception {
        Product product = products.getOrDefault(id, null);
        if(null != product){
            if( null != name){
                product.setName(name);
            }
            if(null != description){
                product.setDescription(description);
            }
            if(null != price){
                product.setPrice(price);
            }
            products.put(id, product);
            return product;
        }
        throw new Exception("No product with id" + id +" found");
    }
}
