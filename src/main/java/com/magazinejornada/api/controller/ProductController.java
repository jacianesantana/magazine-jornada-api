package com.magazinejornada.api.controller;

import com.magazinejornada.api.controller.request.ProductRequest;
import com.magazinejornada.api.controller.response.ProductResponse;
import com.magazinejornada.api.model.Product;
import com.magazinejornada.api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> registerProduct(@Valid @RequestBody ProductRequest productRequest) {
        productService.save(productRequest);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}/update")
    public ResponseEntity<ProductResponse> updateProduct(@RequestBody @Valid @PathVariable Long id, @RequestParam String title, @RequestParam String description){
        return new ResponseEntity<>(productService.updateProduct(id, title, description), HttpStatus.OK);
    }
}
