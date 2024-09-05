package com.example.search.services;

import com.example.search.entity.Product;
import org.springframework.stereotype.Service;

@Service
public interface SolrIndexingService {
    public void indexProduct(Product product);
    public void deleteProduct(String id);
}
