package com.example.back.ecommerce.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "tb_card")
public class CreditCard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String card_holder;
    private String card_number;
    private String valid_thru;
    private String security_code;
    @OneToOne
    private User client;

    public CreditCard() {
    }
    public CreditCard(String id, String card_holder, String card_number, String valid_thru, String security_code){
        this.id = id;
        this.card_holder = card_holder;
        this.card_number = card_number;
        this.valid_thru = valid_thru;
        this.security_code = security_code;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCard_holder() {
        return card_holder;
    }

    public void setCard_holder(String card_holder) {
        this.card_holder = card_holder;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getValid_thru() {
        return valid_thru;
    }

    public void setValid_thru(String valid_thru) {
        this.valid_thru = valid_thru;
    }

    public String getSecurity_code() {
        return security_code;
    }

    public void setSecurity_code(String security_code) {
        this.security_code = security_code;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditCard)) return false;
        CreditCard that = (CreditCard) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
