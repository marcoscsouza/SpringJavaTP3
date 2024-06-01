package com.marcoscsouza.TP3.domain.service;

import com.marcoscsouza.TP3.domain.model.Product;
import com.marcoscsouza.TP3.domain.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    public ResponseEntity<Product> findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(product.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<Product> save(Product product) {
        var productModel = new Product();
        BeanUtils.copyProperties(product, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    public ResponseEntity<Product> update(long id, Product productDto) {
        Optional<Product> productO = productRepository.findById(id);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        var product = productO.get();
        BeanUtils.copyProperties(productDto, product);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(product));
    }

    public ResponseEntity<Product> delete(long id) {
        Optional<Product> productO = productRepository.findById(id);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        productRepository.delete(productO.get());
        return ResponseEntity.status(HttpStatus.OK).body(productO.get());
    }
}
