package com.mruruc.client.service;

import com.mruruc.client.model.Address;
import com.mruruc.client.model.Client;
import com.mruruc.client.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private AddressRepository addressRepository;
    @Autowired
    public AddressService(AddressRepository addressRepository){
        this.addressRepository=addressRepository;
    }

    public Address addAddress(Address address){
        return addressRepository.save(address);
    }

    public List<Address> addAddress(List<Address> address, Client client){
        address.forEach(adrs -> adrs.setClient(client));
        return addressRepository.saveAll(address);
    }
}
