package com.example.search.services.serviceImplementation;

import com.example.search.common.APIResponse;
import com.example.search.common.ProductClient;
import com.example.search.dto.ProductDTO;
import com.example.search.entity.Product;
import com.example.search.entity.Seller;
import com.example.search.repository.ProductRepository;
import com.example.search.services.SolrSearchService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SolrSearchServiceImpl implements SolrSearchService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductClient productClient;

    @Override
    public List<ProductDTO> search(String keyword) {
        List<Product> productList = productRepository.search(keyword);
        List<ProductDTO> productDTOList = new ArrayList<>();
        if(productList != null) {
            for (Product product : productList) {
                ResponseEntity<APIResponse<Product>> response = productClient.findById(product.getPId());
                Product product1 = response.getBody().getData();
                List<Seller> sellerList = product1.getSeller();
                ProductDTO productDTO = new ProductDTO();
                if(sellerList != null){
                    double minPrice = sellerList.get(0).getPrice();
                    String minSId = sellerList.get(0).getSId();
                    for (Seller seller : sellerList) {
                        double price = seller.getPrice();
                        if (price < minPrice) {
                            minPrice = price;
                            minSId = seller.getSId();
                        }
                    }
                    productDTO.setMinPrice(minPrice);
                    productDTO.setMinSId(minSId);
                }
                BeanUtils.copyProperties(product1, productDTO);
                productDTOList.add(productDTO);
            }
            return productDTOList;
        }
        return null;
    }
}
