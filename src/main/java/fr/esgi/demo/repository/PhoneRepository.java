package fr.esgi.demo.repository;

import fr.esgi.demo.domain.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends CrudRepository <Phone, Long>{
    //Phone findById(Long id);
}