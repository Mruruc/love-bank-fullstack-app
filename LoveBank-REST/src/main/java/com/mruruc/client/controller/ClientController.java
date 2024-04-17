package com.mruruc.client.controller;

import com.mruruc.client.model.Client;
import com.mruruc.client.service.AddressService;
import com.mruruc.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "/api")
public class ClientController {
    private ClientService clientService;
    private AddressService addressService;

    @Autowired
    public ClientController(ClientService clientService,AddressService addressService){
        this.clientService=clientService;
        this.addressService=addressService;
    }

    @PostMapping(value = "/register",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void register(@RequestBody Client client){
        clientService.newClient(client);
        addressService.addAddress(client.getAddress(),client);
    }

}
