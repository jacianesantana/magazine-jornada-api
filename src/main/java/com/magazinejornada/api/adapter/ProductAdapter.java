package com.magazinejornada.api.adapter;

import com.magazinejornada.api.controller.request.ProductRequest;
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
}
