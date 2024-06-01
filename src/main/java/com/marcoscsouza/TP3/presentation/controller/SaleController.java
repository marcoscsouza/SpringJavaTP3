package com.marcoscsouza.TP3.presentation.controller;

import com.marcoscsouza.TP3.domain.model.Sale;
import com.marcoscsouza.TP3.domain.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public ResponseEntity<List<Sale>> getAll() {
        return saleService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getById(@PathVariable Long id) {
        return saleService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Sale> save(@RequestBody Sale sale) {
        return saleService.save(sale);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sale> update(@PathVariable Long id, @RequestBody Sale sale) {
        return saleService.update(id,sale);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Sale> delete(@PathVariable Long id) {
        return saleService.delete(id);
    }
}
