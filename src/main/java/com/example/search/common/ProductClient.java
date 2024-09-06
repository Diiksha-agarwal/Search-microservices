package com.example.search.common;

import com.example.search.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="product-service" , url = "http://10.20.3.216:8090")
public interface ProductClient {
    @GetMapping("/product/{pid}")
    public ResponseEntity<APIResponse<Product>> findById(@PathVariable("pid") String pid);
}
