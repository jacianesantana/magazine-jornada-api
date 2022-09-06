package com.magazinejornada.api.service;

import com.magazinejornada.api.adapter.ProductAdapter;
import com.magazinejornada.api.controller.request.ProductRequest;
import com.magazinejornada.api.model.Product;
import com.magazinejornada.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductAdapter productAdapter;

    public void save(ProductRequest productRequest) {
        Product product = productAdapter.toProduct(productRequest);
        productRepository.save(product);
    }
}
