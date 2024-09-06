package com.example.search.services;

import com.example.search.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SolrSearchService {
    public List<ProductDTO> search(String keyword);
}
