package com.example.search.controller;

import com.example.search.common.APIResponse;
import com.example.search.dto.ProductDTO;
import com.example.search.entity.Product;
import com.example.search.services.SolrIndexingService;
import com.example.search.services.SolrSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<APIResponse<List<ProductDTO>>>search(@RequestParam String keyword) {
        List<ProductDTO> productDTOList =  solrSearchService.search(keyword);
        if (productDTOList == null)
            return new ResponseEntity<>(new APIResponse<>(false,"something went wrong"),HttpStatus.BAD_REQUEST);
        if(productDTOList.isEmpty())
            return new ResponseEntity<>(new APIResponse<>(false,"No matching result"), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(new APIResponse<>(productDTOList),HttpStatus.OK);
    }
    @CrossOrigin
    @DeleteMapping("/delete")
    public void deleteById(String id){
        solrIndexingService.deleteProduct(id);
    }
}
