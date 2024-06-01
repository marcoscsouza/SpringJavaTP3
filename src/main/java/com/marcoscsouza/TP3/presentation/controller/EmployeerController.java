package com.marcoscsouza.TP3.presentation.controller;

import com.marcoscsouza.TP3.domain.model.Employeer;
import com.marcoscsouza.TP3.domain.service.EmployeerService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeer")
public class EmployeerController {

    @Autowired
    private EmployeerService employeerService;

    @GetMapping
    public ResponseEntity<List<Employeer>> listar() {
        return employeerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employeer> findById(@PathVariable Long id) {
        return employeerService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Employeer> create(@RequestBody Employeer employeer) {
        return employeerService.save(employeer);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employeer> update(@PathVariable Long id, @RequestBody Employeer employeer) {
        return employeerService.update(id, employeer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employeer> delete(@PathVariable Long id) {
        return employeerService.delete(id);
    }
}
