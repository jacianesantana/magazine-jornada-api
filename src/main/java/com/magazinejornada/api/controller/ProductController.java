package com.magazinejornada.api.controller;

import com.magazinejornada.api.controller.request.ProductRequest;
import com.magazinejornada.api.controller.request.UpdateProductRequest;
import com.magazinejornada.api.controller.response.ProductResponse;
import com.magazinejornada.api.model.Product;
import com.magazinejornada.api.repository.ProductRepository;
import com.magazinejornada.api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> listProducts(){
        return productRepository.findAll();
    }
    @GetMapping("/Product/{id}")
    public Product listProduct(@PathVariable(value = "id") long id){
        return productRepository.findById(id);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id,
                                                         @RequestBody UpdateProductRequest updateProductRequest){
        return new ResponseEntity<>(productService.update(id, updateProductRequest), HttpStatus.OK);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
