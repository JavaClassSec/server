package org.example.ex06.product.service;

import org.example.ex06.product.dto.request.PostRequest;
import org.example.ex06.product.dto.request.UpdatePostRequest;
import org.example.ex06.product.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product postProduct(PostRequest request);

    void deleteProduct(Long id);

    Product updateProduct(UpdatePostRequest request);

    Product getProduct(Long id);
}
