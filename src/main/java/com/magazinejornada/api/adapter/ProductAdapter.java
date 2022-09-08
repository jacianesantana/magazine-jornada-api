package com.magazinejornada.api.adapter;

import com.magazinejornada.api.controller.request.ProductRequest;
import com.magazinejornada.api.controller.response.ProductResponse;
import com.magazinejornada.api.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductAdapter {

    public Product toProduct(ProductRequest productRequest) {
        return Product.builder()
                .title(productRequest.getTitle())
                .description(productRequest.getDescription())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .picture(productRequest.getPicture())
                .build();
    }
    public ProductResponse toProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getDescription())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .picture(product.getPicture())
                .build();
    }
}
