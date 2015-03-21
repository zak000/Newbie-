package fr.esgi.demo.web;

import fr.esgi.demo.domain.Phone;

import java.lang.reflect.Type;

public class PhoneDTO {

    private Long id;
    private String serialNumber;
    private String Number;
    private String firstname;
    private String lastname;
    private Boolean stolen;


    public void hydrateMethod(Phone phone) {
        id = phone.getId();
        firstname = phone.getFirstname();
        lastname = phone.getLastname();
        serialNumber = phone.getSerialNumber();
        stolen = phone.getStolen();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStolen() {
        return stolen;
    }

    public void setStolen(Boolean stolen) {
        this.stolen = stolen;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}