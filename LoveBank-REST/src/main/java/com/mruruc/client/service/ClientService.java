package com.mruruc.client.service;

import com.mruruc.client.model.Client;
import com.mruruc.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private ClientRepository repository;

    @Autowired
    public ClientService(ClientRepository repository) {
        this.repository=repository;
    }

    public Client newClient(Client client) {
         return repository.save(client);
    }

    public List<Client> getClients() {
        return repository.findAll();
    }

    public Optional<Client> findClientById(Long id){
        return repository.findById(id);
    }

}
