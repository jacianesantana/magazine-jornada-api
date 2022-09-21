package com.magazinejornada.api.controller;

import com.magazinejornada.api.controller.request.ProductRequest;
import com.magazinejornada.api.controller.request.UpdateProductRequest;
import com.magazinejornada.api.controller.response.ProductResponse;
import com.magazinejornada.api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> registerProduct(@RequestBody ProductRequest productRequest) {
        productService.save(productRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> listProducts(){
        return ResponseEntity.ok(productService.listAll());
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id,
                                                         @RequestBody UpdateProductRequest updateProductRequest){
        return new ResponseEntity<>(productService.update(id, updateProductRequest), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
