package fr.esgi.demo.domain;

/**
 * Created by Romain on 20/03/15.
 */

import javax.persistence.*;

@Entity
public class PhoneConfiguration {

    @Id
    @GeneratedValue
    private Long id;
    private String name;


    public PhoneConfiguration() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneConfiguration that = (PhoneConfiguration) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

}