package com.example.JPATest;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;



@RestController

public class RestWebService {



   PersonRepository personRepository;
   VehiculeRepository vehiculeRepository;



    @Autowired

    public RestWebService(PersonRepository personRepository , VehiculeRepository vehiculeRepository) {

        super();

        this.personRepository = personRepository;
        this.vehiculeRepository = vehiculeRepository;

    }



    @GetMapping("/vehicules")

    public Iterable<Vehicule> getvehicules(){

        return vehiculeRepository.findAll();

    }


    @GetMapping("/persons")

    public Iterable<Person> getpersons(){

        return personRepository.findAll();

    }





}
