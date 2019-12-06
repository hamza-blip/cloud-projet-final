package com.example.JPATest;
import java.util.ArrayList;

import java.util.HashSet;

import java.util.List;

import java.util.Set;



import javax.persistence.CascadeType;

import javax.persistence.Entity;

import javax.persistence.FetchType;

import javax.persistence.Id;

import javax.persistence.OneToMany;



import com.fasterxml.jackson.annotation.JsonIgnore;
import net.bytebuddy.implementation.bind.annotation.Super;

@Entity
public class Van extends Vehicule {
    private int maxWeight;

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Van() {
        super();
    }

    public Van(int maxWeight, long num) {
        this.maxWeight = maxWeight;
        this.plateNumber = num;
    }

    @Override
    public String toString() {
        return "Van[plateNumber=" + plateNumber + " , maxWeight=" + maxWeight + " , rents=" +rents+ "]";
    }


}
