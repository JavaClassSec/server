package org.example.ex06.product.controller;

import lombok.RequiredArgsConstructor;
import org.example.ex06.product.dto.request.PostRequest;
import org.example.ex06.product.dto.request.UpdatePostRequest;
import org.example.ex06.product.entity.Product;
import org.example.ex06.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PostMapping
    public Product postProduct(@RequestBody PostRequest request){
        return productService.postProduct(request);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    @PatchMapping
    public Product updateProduct(@RequestBody UpdatePostRequest request){
        return productService.updateProduct(request);
    }
}
