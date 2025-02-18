package com.example.TweetManagementSystem.restController;

import com.example.TweetManagementSystem.entity.Address;
import com.example.TweetManagementSystem.entity.Person;
import com.example.TweetManagementSystem.entity.Tweets;
import com.example.TweetManagementSystem.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/persons")
    public ResponseEntity<String> addNewPerson(@RequestBody Person person){
        personService.addNewPerson(person);
        return new ResponseEntity<>("Data added !!", HttpStatus.CREATED);
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersonsData(){
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }

    @GetMapping("/persons/{id}/tweets")
    public ResponseEntity<List<Tweets>> getTweetsByPerson(@PathVariable Long id){
        return new ResponseEntity<>(personService.getPersonById(id).getTweets(), HttpStatus.OK);
    }

    @GetMapping("/persons/{id}/address")
    public ResponseEntity<Address> getAddressOfPerson(@PathVariable Long id){
        return new ResponseEntity<>(personService.getPersonById(id).getAddress(), HttpStatus.OK);
    }
}
