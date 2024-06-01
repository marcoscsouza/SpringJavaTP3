package com.marcoscsouza.TP3.presentation.controller;

import com.marcoscsouza.TP3.domain.model.Supplier;
import com.marcoscsouza.TP3.domain.repository.SupplierRepository;
import com.marcoscsouza.TP3.domain.service.SupplierService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return supplierService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
        return supplierService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        return supplierService.save(supplier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
        return supplierService.update(id, supplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Supplier> deleteSupplier(@PathVariable Long id) {
        return supplierService.delete(id);
    }
}
