package com.example.TweetManagementSystem.service;

import com.example.TweetManagementSystem.entity.Person;
import com.example.TweetManagementSystem.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void addNewPerson(Person person){
        personRepository.save(person);
    }

    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    public Person getPersonById(Long id){
        return personRepository.findById(id).get();
    }
}
