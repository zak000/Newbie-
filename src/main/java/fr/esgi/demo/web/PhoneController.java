package fr.esgi.demo.web;

import fr.esgi.demo.domain.Phone;
import fr.esgi.demo.repository.PhoneRepository;
import fr.esgi.demo.web.PhoneDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/phone")
public class PhoneController {

    @Autowired
    private PhoneRepository phoneRepository;
    private ArrayList<PhoneDTO> phone = new ArrayList<>();

    @RequestMapping(method = RequestMethod.GET)
    public List<PhoneDTO> getPhones() {
        Iterable<Phone> phones = phoneRepository.findAll();

        while (phones.iterator().hasNext()) {
            PhoneDTO phoneDTO = new PhoneDTO();
            Phone listPhoneBDD = phones.iterator().next();

            phoneDTO.hydrateMethod(listPhoneBDD);

            phone.add(phoneDTO);
        }

        return phone;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/stolen")
    public List<PhoneDTO> getPhonesStolen() {
        ArrayList<PhoneDTO> phoneStolen = new ArrayList<>();

        for (int i = 1; i < phone.size(); i++) {
            PhoneDTO listPhone = phone.get(i);
            System.out.println("for");
            if (listPhone.getStolen()) {
                System.out.println("Test");
                phoneStolen.add(listPhone);
            }
        }

        return phoneStolen;
    }

    /*@RequestMapping(value="/{phoneId}", method = RequestMethod.GET)
    public PhoneDTO getPhone(@PathVariable Long phoneId) {
        Phone phone = phoneRepository.findOne(phoneId);
        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setFirstname(phone.getFirstname());
        phoneDTO.setLastname(phone.getLastname());
        phoneDTO.setSerialNumber(phone.getSerialNumber());
        phoneDTO.setNumber(phone.getNumber());
        phoneDTO.setStolen(phone.isStolen());
        return phoneDTO;
    }*/

    /*@RequestMapping(method = RequestMethod.GET)
    public PhoneDTO getPhone() {

        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setId(1L);
        phoneDTO.setSerialNumber("1234");
        phoneDTO.setNumber("08001928");
        phoneDTO.setFirstname("Alex");
        phoneDTO.setLastname("Java");
        phoneDTO.setStolen(PhoneDTO.Type.FALSE);

        return phoneDTO;
    }*/

}
