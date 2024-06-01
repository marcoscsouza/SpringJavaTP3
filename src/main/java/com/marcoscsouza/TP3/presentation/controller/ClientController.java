package com.marcoscsouza.TP3.presentation.controller;

import com.marcoscsouza.TP3.domain.model.Client;
import com.marcoscsouza.TP3.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> listar() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Client> salvar(@RequestBody Client client) {
        return clientService.save(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
        return clientService.update(id, client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> delete(@PathVariable Long id) {
        return clientService.delete(id);
    }
}
