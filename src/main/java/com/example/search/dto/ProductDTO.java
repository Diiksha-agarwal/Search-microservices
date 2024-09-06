package com.example.search.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String pId;
    private String pName;
    private String description;
    private String image;
    private double minPrice;
    private String minSId;
}
