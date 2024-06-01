package com.marcoscsouza.TP3.domain.service;

import com.marcoscsouza.TP3.domain.model.Sale;
import com.marcoscsouza.TP3.domain.repository.SaleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public ResponseEntity<List<Sale>> findAll() {
        List<Sale> sales = saleRepository.findAll();
        if (sales.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sales);
    }

    public ResponseEntity<Sale> findById(Long id) {
        Optional<Sale> sales = saleRepository.findById(id);
        if (sales.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(sales.get());
    }

    public ResponseEntity<Sale> save(Sale sale) {
        var saleModel = new Sale();
        BeanUtils.copyProperties(sale, saleModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(saleRepository.save(saleModel));
    }

    public ResponseEntity<Sale> update(Long id, Sale saleDto) {
        Optional<Sale> salesO = saleRepository.findById(id);
        if (salesO.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var sale = salesO.get();
        BeanUtils.copyProperties(sale, saleDto);
        return ResponseEntity.status(HttpStatus.OK).body(saleRepository.save(sale));
    }

    public ResponseEntity<Sale> delete(Long id) {
        Optional<Sale> salesO = saleRepository.findById(id);
        if (salesO.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        saleRepository.delete(salesO.get());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
