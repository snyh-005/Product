package io.github.snyh005.multibank.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    public Integer id;
    public String name;
    public String description;
    public Long price;
    
}
