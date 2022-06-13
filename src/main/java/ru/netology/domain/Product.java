package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
//@AllArgsConstructor
@Data
public class Product {
    protected int id;
    protected String name;
    protected int cost;

    public Product (int id, String name, int cost){
        this. id = id;
        this. name = name;
        this.cost = cost;
    }
}
