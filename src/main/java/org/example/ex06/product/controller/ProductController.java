package org.example.ex06.product.controller;

import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "전체 상품 조회" , description = "전체 상품을 조회하는 api입니다.")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    @Operation(summary = "단일 상품 조회" , description = "상품을 상세 조회하는 api입니다.")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PostMapping
    @Operation(summary = "상품 생성" , description = "상품을 생성 api입니다.")
    public Product postProduct(@RequestBody PostRequest request){
        return productService.postProduct(request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "상품 삭제" , description = "상품을 삭제하는 api입니다.")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    @PatchMapping
    @Operation(summary = "상품 수정" , description = "상품의 정보를 수정하는 api입니다.")
    public Product updateProduct(@RequestBody UpdatePostRequest request){
        return productService.updateProduct(request);
    }

    @PutMapping
    @Operation(summary = "상품 수정" , description = "상품의 정보를 수정하는 api입니다.")
    public Product putProduct(@RequestBody UpdatePostRequest request){
        return productService.updateProduct(request);
    }
}
