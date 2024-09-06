package com.example.search.services.serviceImplementation;

import com.example.search.entity.Product;
import com.example.search.repository.ProductRepository;
import com.example.search.services.SolrIndexingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Service;

@Service
public class SolrIndexingServiceImpl implements SolrIndexingService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SolrTemplate solrTemplate;

    public void indexProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
        solrTemplate.commit("Product");
    }

}
