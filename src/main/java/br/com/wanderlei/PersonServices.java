package br.com.wanderlei;

import br.com.wanderlei.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong  counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName ());

    public List<Person> findAll() {
        logger.info("Finding all People");

        List<Person> persons = new ArrayList<Person> ();
        for (int i =0; i<20; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId (counter.incrementAndGet ());
        person.setFirstName ("First Name " + i);
        person.setLastName ("Last Name " + i);
        person.setAddress ("Some Address in Brazil");
        person.setGender ("Male");
        return person;
    }

    public Person findById(String id) {
        logger.info("Finding one Person");

        Person person = new Person();
        person.setId (counter.incrementAndGet ());
        person.setFirstName ("Wanderlei");
        person.setLastName ("Bolzan");
        person.setAddress ("São Carlos - SP");
        person.setGender ("Male");

        return person;
    }

    public Person create(Person person) {
        logger.info("Creating one Person");

        return person;
    }
    public Person updade(Person person) {
        logger.info("Updating one Person");

        return person;
    }

    public void delete(String id) {
        logger.info("Deleting one Person");

    }

}
