package com.example.search.services.serviceImplementation;

import com.example.search.entity.Product;
import com.example.search.repository.ProductRepository;
import com.example.search.services.SolrSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SolrSearchServiceImpl implements SolrSearchService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> search(String keyword) {
        return productRepository.search(keyword);
    }
}
