package com.magazinejornada.api.service;

import com.magazinejornada.api.adapter.ProductAdapter;
import com.magazinejornada.api.controller.request.ProductRequest;
import com.magazinejornada.api.controller.request.UpdateProductRequest;
import com.magazinejornada.api.controller.response.ProductResponse;
import com.magazinejornada.api.model.Product;
import com.magazinejornada.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductAdapter productAdapter;

    public void save(ProductRequest productRequest) {
        Product product = productAdapter.toProduct(productRequest);
        productRepository.save(product);
    }

    public List<Product> listProduct(){
        return productRepository.findAll();
    }

    public ProductResponse update(Long id, UpdateProductRequest updateProductRequest){
        var product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setTitle(updateProductRequest.getTitle());
        product.setDescription(updateProductRequest.getDescription());
        var productResponse = productRepository.save(product);
        return productAdapter.toProductResponse(productResponse);
    }

    public void delete(long id) {
    }
}
