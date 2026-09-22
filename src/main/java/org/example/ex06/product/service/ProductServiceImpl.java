package org.example.ex06.product.service;

import lombok.RequiredArgsConstructor;
import org.example.ex06.product.dto.request.PostRequest;
import org.example.ex06.product.dto.request.UpdatePostRequest;
import org.example.ex06.product.entity.Product;
import org.example.ex06.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product postProduct(PostRequest request) {
        Product product = Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .build();

        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(UpdatePostRequest request) {
        Product product = productRepository.findById(request.id())
                .orElseThrow(
                        () -> new IllegalArgumentException("없는 product입니다.")
                );
        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());

        return productRepository.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("없는 product입니다.")
        );
    }
}
