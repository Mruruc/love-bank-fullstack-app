package com.mruruc.client.model;

import com.mruruc.login.model.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Table(name = "client",
        uniqueConstraints = {
                @UniqueConstraint(name = "email_unique_constraint",columnNames = "email"),
                @UniqueConstraint(name = "unique_phone_constraint",columnNames = "phone")
        })
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "client_seq")
    @SequenceGenerator(name = "client_seq",allocationSize = 1)
    @Column(name = "client_id")
    private Long id;
    @Column(length = 50,nullable = false)
    private String firstName;
    @Column(length = 50,nullable = false)
    private String lastName;
    @Column(nullable = false)
    private LocalDate dob;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
  //  private List<String> phone;  // after revisiting the JPA and Hibernate, should be revisited.
    @Column(length = 12,nullable = false,unique = true)
    private String phone;
    @Column(length = 50,unique = true)
    private String email;
    @OneToMany(mappedBy = "client",
              cascade = CascadeType.REMOVE,
              fetch = FetchType.EAGER)
    private List<Address> address;
    @OneToOne(mappedBy = "client", fetch = FetchType.LAZY)
    private User user;


    public Client() {}

    public Client(String firstName,
                  String lastName, LocalDate dob,
                  Gender gender, String phone,
                  String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }

    public Client(Long id, String firstName,
                  String lastName, LocalDate dob,
                  Gender gender, String phone, String email,
                  List<Address> address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + getAge() +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
