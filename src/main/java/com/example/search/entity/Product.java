package com.example.search.entity;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.List;

@Data
@SolrDocument(collection = "Product")
public class Product {
    @Id
    private String pId;
    @Field
    private String pName;
    @Field
    private String image;
    @Field
    private List<String> usp;
    @Field
    private List<String> attribute;
    @Field
    private String description;
    @Field
    private List<Seller> seller;
}
