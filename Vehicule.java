package com.example.JPATest;
import java.util.ArrayList;

import java.util.HashSet;

import java.util.List;

import java.util.Set;


import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;
import net.bytebuddy.implementation.bind.annotation.Super;


@Entity
public class Vehicule {
    public long plateNumber;
    protected List<rent> rents = new ArrayList<rent>();

    public Vehicule(){
        super();
    }


    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    public long getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(long plateNumber) {
        this.plateNumber = plateNumber;
    }

    @JsonIgnore
    @OneToMany(mappedBy="vehicule")
    public List<rent> getRents() {
        return rents;
    }

    public void setRents(List<rent> rents) {
        this.rents = rents;
    }


    @Override
    public String toString(){
        return "Vehicule[plateNumber="+plateNumber+" , rents="+rents+"]";
    }


}


