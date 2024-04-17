package com.mruruc.client.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "address_seq_generator")
    @SequenceGenerator(name ="address_seq_generator" ,initialValue = 1,allocationSize = 1)
    private Long addressId;
    private String country;
    private String city;
    private String street;
    private String zip;
    private Integer doorNo;
    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    Client client;

    public Address(){}

    public Address(Long addressId, String country, String city, String street, String zip, Integer doorNo) {
        this.addressId = addressId;
        this.country = country;
        this.city = city;
        this.street = street;
        this.zip = zip;
        this.doorNo = doorNo;
    }
    public Address(String country, String city, String street, String zip, Integer doorNo,Client client) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.zip = zip;
        this.doorNo = doorNo;
        this.client=client;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Integer getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(Integer doorNo) {
        this.doorNo = doorNo;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zip='" + zip + '\'' +
                ", doorNo=" + doorNo +
                '}';
    }
}
