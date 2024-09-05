package com.example.search.controller;

import com.example.search.entity.Product;
import com.example.search.services.SolrIndexingService;
import com.example.search.services.SolrSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class ProductController {

    @Autowired
    private SolrSearchService solrSearchService;
    @Autowired
    private SolrIndexingService solrIndexingService;

    @CrossOrigin
    @PostMapping("/index")
    public void indexProduct(@RequestBody Product product) {
        solrIndexingService.indexProduct(product);
    }
    @CrossOrigin
    @GetMapping("/")
    public List<Product> search(@RequestParam String keyword) {
        return solrSearchService.search(keyword);
    }
    @CrossOrigin
    @DeleteMapping("/delete")
    public void deleteById(String id){
        solrIndexingService.deleteProduct(id);
    }
}
