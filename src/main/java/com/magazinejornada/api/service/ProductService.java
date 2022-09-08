package com.magazinejornada.api.service;

import com.magazinejornada.api.adapter.ProductAdapter;
import com.magazinejornada.api.controller.request.ProductRequest;
import com.magazinejornada.api.controller.response.ProductResponse;
import com.magazinejornada.api.model.Product;
import com.magazinejornada.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.management.monitor.StringMonitorMBean;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductAdapter productAdapter;

    public void save(ProductRequest productRequest) {
        Product product = productAdapter.toProduct(productRequest);
        productRepository.save(product);
    }
    public ProductResponse updateProduct(Long id, String title, String description){
        var product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setTitle(title);
        product.setDescription(description);
        return productAdapter.toProductResponse(productRepository.save(product));
    }
}
