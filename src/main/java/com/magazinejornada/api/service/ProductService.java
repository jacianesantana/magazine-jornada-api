package com.magazinejornada.api.service;

import com.magazinejornada.api.adapter.ProductAdapter;
import com.magazinejornada.api.controller.request.ProductRequest;
import com.magazinejornada.api.controller.request.UpdateProductRequest;
import com.magazinejornada.api.controller.response.ProductResponse;
import com.magazinejornada.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductAdapter productAdapter;

    public void save(ProductRequest productRequest) {
        var product = productAdapter.toProduct(productRequest);
        productRepository.save(product);
    }

    public List<ProductResponse> listAll(){
        return productRepository.findAll()
                .stream()
                .map(productAdapter::toProductResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse update(Long id, UpdateProductRequest updateProductRequest){
        var product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setTitle(updateProductRequest.getTitle());
        product.setDescription(updateProductRequest.getDescription());
        var productResponse = productRepository.save(product);
        return productAdapter.toProductResponse(productResponse);
    }

    public void delete(Long id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
    }

}
