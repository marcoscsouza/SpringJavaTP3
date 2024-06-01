package com.marcoscsouza.TP3.domain.service;

import com.marcoscsouza.TP3.domain.model.Employeer;
import com.marcoscsouza.TP3.domain.repository.EmployeerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeerService {

    @Autowired
    private EmployeerRepository employeerRepository;

    public ResponseEntity<List<Employeer>> findAll() {
        List<Employeer> employeers = employeerRepository.findAll();
        return ResponseEntity.ok(employeers);
    }

    public ResponseEntity<Employeer> findById(Long id) {
        Optional<Employeer> employeer = employeerRepository.findById(id);
        if (employeer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employeer.get());
    }

    public ResponseEntity<Employeer> save(Employeer employeer) {
        var employeerModel = new Employeer();
        BeanUtils.copyProperties(employeer, employeerModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeerRepository.save(employeerModel));
    }

    public ResponseEntity<Employeer> update(Long id, Employeer employeer) {
        Optional<Employeer> employeerModel = employeerRepository.findById(id);
        if (employeerModel.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(employeer, employeerModel);
        return ResponseEntity.status(HttpStatus.OK).body(employeerRepository.save(employeerModel.get()));
    }

    public ResponseEntity<Employeer> delete(Long id) {
        Optional<Employeer> employeerO = employeerRepository.findById(id);
        if (employeerO.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        employeerRepository.delete(employeerO.get());
        return ResponseEntity.noContent().build();
    }
}
