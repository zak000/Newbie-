package fr.esgi.demo.domain;

import fr.esgi.demo.web.PhoneDTO;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Phone")
public class Phone {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String serialNumber;

    @Column
    private String number;

    @Column
    private String firstname;

    @Column
    private String lastname;

    private Boolean stolen;
    /*private List<PhonePreference> phonePreference;
    private PhoneConfiguration phoneConfiguration;*/

    public Phone() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public Boolean getStolen() {
        return stolen;
    }

    public void setStolen(Boolean stolen) {
        this.stolen = stolen;
    }


/*
    public void setPhonePreference(List<PhonePreference> phonePreference) {
        this.phonePreference = phonePreference;
    }

    public void setPhoneConfiguration(PhoneConfiguration phoneConfiguration) {
        this.phoneConfiguration = phoneConfiguration;
    }

    public PhoneConfiguration getPhoneConfiguration() {
        return phoneConfiguration;
    }

    public List<PhonePreference> getPhonePreference() {
        return phonePreference;
    }*/
}

    /*
@OneToMany
private List<UserPreference> userPreference;
*/
