package com.example.JPATest;
import java.util.ArrayList;

import java.util.HashSet;

import java.util.List;

import java.util.Set;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Person {
    private long id;
    private String name;

    public void setId(long id) {
        this.id = id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    private List<rent> rents = new ArrayList<rent>();
    public Person(){
        super();
    }

    public Person(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    @OneToMany(mappedBy="person", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    public List<rent> getRents() {
        return rents;
    }

    public void setRents(List<rent> rents) {
        this.rents = rents;
    }






    @Override
    public String toString(){
        return "Person[name="+name+" , rents="+rents+"]";
    }

}
