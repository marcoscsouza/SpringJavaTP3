package com.marcoscsouza.TP3.domain.service;

import com.marcoscsouza.TP3.domain.model.Supplier;
import com.marcoscsouza.TP3.domain.repository.SupplierRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public ResponseEntity<List<Supplier>> findAll() {
        List<Supplier> suppliers = supplierRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(suppliers);
    }

    public ResponseEntity<Supplier> findById(Long id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        if (supplier.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(supplier.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<Supplier> save(Supplier supplier) {
        var supplierModel = new Supplier();
        BeanUtils.copyProperties(supplier, supplierModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierRepository.save(supplierModel));
    }

    public ResponseEntity<Supplier> update(Long id, Supplier supplierDto) {
        Optional<Supplier> supplierO = supplierRepository.findById(id);
        if (supplierO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        var supplier = supplierO.get();
        BeanUtils.copyProperties(supplierDto, supplier);
        return ResponseEntity.status(HttpStatus.OK).body(supplierRepository.save(supplier));
    }

    public ResponseEntity<Supplier> delete(Long id) {
        Optional<Supplier> supplierO = supplierRepository.findById(id);
        if (supplierO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        supplierRepository.delete(supplierO.get());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
