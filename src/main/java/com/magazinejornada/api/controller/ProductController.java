package com.magazinejornada.api.controller;

import com.magazinejornada.api.controller.request.ProductRequest;
import com.magazinejornada.api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> registerProduct(@Valid @RequestBody ProductRequest productRequest) {
        productService.save(productRequest);
        return ResponseEntity.ok().build();
    }

}
