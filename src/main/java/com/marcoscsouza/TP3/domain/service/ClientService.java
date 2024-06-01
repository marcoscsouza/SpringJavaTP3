package com.marcoscsouza.TP3.domain.service;

import com.marcoscsouza.TP3.domain.model.Client;
import com.marcoscsouza.TP3.domain.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ResponseEntity<List<Client>> findAll() {
        List<Client> clients = clientRepository.findAll();
        return ResponseEntity.ok(clients);
    }

    public ResponseEntity<Client> findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(client.get());
    }

    public ResponseEntity<Client> save(Client client) {
        var ClientModel = new Client();
        BeanUtils.copyProperties(client, ClientModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientRepository.save(ClientModel));
    }

    public ResponseEntity<Client> update(Long id, Client clientDto) {
        Optional<Client> clientO = clientRepository.findById(id);
        if (clientO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        var client = clientO.get();
        BeanUtils.copyProperties(clientDto, client);
        return ResponseEntity.status(HttpStatus.OK).body(clientRepository.save(client));
    }

    public ResponseEntity<Client> delete(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        clientRepository.delete(client.get());
        return ResponseEntity.status(HttpStatus.OK).body(client.get());
    }
}
