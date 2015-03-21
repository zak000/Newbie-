package fr.esgi.demo.domain;


import fr.esgi.demo.DemoApplication;
import fr.esgi.demo.repository.PhoneRepository;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.transaction.Transactional;
import java.util.Arrays;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
public class PhoneTest {

    @Autowired
    private PhoneRepository phoneRepository;
    private Phone phone;

    @Before
    public void setUp() {

        Long id;
        String serialNumber;
        String Number;
        String firstname;
        String lastname;
        boolean stolen;

        Phone phone = new Phone();
        phone.setFirstname(phone.getFirstname());
        phone.setLastname(phone.getLastname());
        phone.setSerialNumber(phone.getSerialNumber());
        phone.setNumber(phone.getNumber());
        phone.setStolen(phone.getStolen());
/*
        PhonePreference phonePreferenceFirst = new PhonePreference();
        PhonePreference phonePreferenceSecond = new PhonePreference();

        phone.setPhonePreference(Arrays.asList(phonePreferenceFirst, phonePreferenceSecond));

        PhoneConfiguration userConfiguration = new PhoneConfiguration();

        phone.setPhoneConfiguration(userConfiguration);
*/
        this.phone = phoneRepository.save(phone);

    }

    @Test
    public void shouldFindByIdSavedPhone() {
        Phone phoneFound = phoneRepository.findOne(this.phone.getId());

        if(phoneRepository.exists(this.phone.getId())) {
            assertThat(this.phone.getId(), Matchers.is(phoneFound.getId()));
            assertThat(this.phone.getFirstname(), Matchers.is(phoneFound.getFirstname()));
            assertThat(this.phone.getLastname(), Matchers.is(phoneFound.getLastname()));
            assertThat(this.phone.getNumber(), Matchers.is(phoneFound.getNumber()));
            assertThat(this.phone.getSerialNumber(), Matchers.is(phoneFound.getSerialNumber()));
            assertThat(this.phone.getStolen(), Matchers.is(phoneFound.getStolen()));
            assertThat(this.phone, Matchers.is(phoneFound));

            /*
            assertThat(this.phone.getPhoneConfiguration(), Matchers.is(phone.getPhoneConfiguration()));
            assertThat(this.phone.getPhonePreference().get(0), notNullValue());
            assertThat(this.phone.getPhonePreference().get(1), notNullValue());
            */
        } else {
            throw new IllegalArgumentException();
        }
    }

   /* @Test
    public void shouldFindByIDSavedPhone() {
        Phone phoneFound = phoneRepository.findById(this.phone.getId());
        assertThat(phoneFound, Matchers.is(this.phone));
    }*/

    @Test
    public void shouldSavePhoneAndGeneratedId() {

        String serialNumber = "3000001";
        String number = "0123456789";
        String firstname = "Toto";
        String lastname = "Java";
        boolean stolen = true;

        Phone phone = new Phone();
        phone.setFirstname(firstname);
        phone.setLastname(lastname);
        phone.setSerialNumber(serialNumber);
        phone.setNumber(number);
        phone.setStolen(stolen);

        Phone savePhone = phoneRepository.save(phone);

        assertThat(savePhone, notNullValue());
        assertThat(savePhone.getId(), notNullValue());
        assertThat(savePhone.getFirstname(), is(firstname));
        assertThat(savePhone.getLastname(), is(lastname));
        assertThat(savePhone.getNumber(), is(number));
        assertThat(savePhone.getSerialNumber(), is(serialNumber));
        assertThat(savePhone.getStolen(), is(stolen));
    }
}