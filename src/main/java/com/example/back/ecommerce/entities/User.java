package com.example.back.ecommerce.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name = "tb_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String lastName;
    private String cpf;
    private String email;
    private String password;
    private String cep;
    private String street;
    private Integer house_number;
    private String neighbour;

    public User(){}

    public User(String id, String name, String lastName, String cpf, String email, String password, String cep, String street,
                Integer house_number, String neighbour){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.cep = cep;
        this.street = street;
        this.house_number = house_number;
        this.neighbour = neighbour;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouse_number() {
        return house_number;
    }

    public void setHouse_number(Integer house_number) {
        this.house_number = house_number;
    }

    public String getNeighbour() {
        return neighbour;
    }

    public void setNeighbour(String neighbour) {
        this.neighbour = neighbour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId().equals(user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
