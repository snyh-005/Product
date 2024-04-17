package io.github.snyh005.multibank.controller;

import io.github.snyh005.multibank.model.Product;
import io.github.snyh005.multibank.model.UserAuthentication;
import io.github.snyh005.multibank.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private final ProductService productService;

    private final UserAuthentication userAuthentication;

    public ProductController(ProductService productService, UserAuthentication userAuthentication) {
        this.productService = productService;
        this.userAuthentication = userAuthentication;
    }


    @PostMapping()
    public Product create(@RequestHeader(value = "Authorization") String token,
                          @RequestBody Product product) throws Exception {
        userAuthentication.isAuthenticated(token);
        return productService.createProduct(product);
    }

    @GetMapping()
    public List<Product> getProduct(@RequestHeader(value ="Authorization") String token,
                                    @RequestParam(required = false) Integer productId) throws Exception {
        userAuthentication.isAuthenticated(token);
        return productService.getProduct(productId);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@RequestHeader(value ="Authorization") String token,
                              @PathVariable(required = true) Integer productId) throws Exception {
        userAuthentication.isAuthenticated(token);
        productService.deleteProduct(productId);
    }

    @PutMapping()
    public Product editProduct(@RequestHeader(value ="Authorization") String token,
                               @RequestParam(required =true) Integer id,
                               @RequestParam (required =false) String name,
                               @RequestParam (required =false) String description,
                               @RequestParam (required =false) Long price) throws Exception {
        userAuthentication.isAuthenticated(token);
        return productService.editProduct(id, name,description, price);
    }
}
