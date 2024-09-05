package com.example.search.repository;

import com.example.search.entity.Product;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import java.util.List;

public interface ProductRepository extends SolrCrudRepository<Product, String> {
    @Query("pName:*?0*^3 OR description:*?0*^2 OR usp:*?0*^1 OR attribute:*?0*^1")
    List<Product> search(String keyword);
}
