package com.example.search.services;

import com.example.search.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SolrSearchService {
    public List<Product> search(String keyword);
}
