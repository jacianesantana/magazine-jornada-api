package com.magazinejornada.api.controller;

import com.magazinejornada.api.controller.request.ProductRequest;
import com.magazinejornada.api.controller.request.UpdateProductRequest;
import com.magazinejornada.api.controller.response.ProductResponse;
import com.magazinejornada.api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @PreAuthorize("hasRole('PARTNER')")
    public ResponseEntity<Void> registerProduct(@Valid @RequestBody ProductRequest productRequest) {
        productService.save(productRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping

    public ResponseEntity<List<ProductResponse>> listProducts(){
        return ResponseEntity.ok(productService.listAll());
    }

    @GetMapping("/{partner}")
    @PreAuthorize("hasRole('PARTNER')")
    public ResponseEntity<List<ProductResponse>> listProductsPartner(@PathVariable Long partner) {
        return ResponseEntity.ok(productService.listByPartner(partner));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id,
                                                         @RequestBody UpdateProductRequest updateProductRequest){
        return new ResponseEntity<>(productService.update(id, updateProductRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
