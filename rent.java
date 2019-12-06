package com.example.JPATest;
import java.util.*;


import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;
import net.bytebuddy.implementation.bind.annotation.Super;

@Entity
public class rent {
    private Date beginRent;
    private Date endRent;
    private Person person;
    private Vehicule vehicule;
    private long id;



    public Date getBeginRent() {
        return beginRent;
    }

    public void setBeginRent(Date beginRent) {
        this.beginRent = beginRent;
    }

    public Date getEndRent() {
        return endRent;
    }

    public void setEndRent(Date endRent) {
        this.endRent = endRent;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }



    @ManyToOne
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getid() {
        return id;
    }

    public void setid(long id) {
        this.id = id;
    }

    public rent() {super(); }

    public rent( Date begin, Date end) {

        this.beginRent = begin;
        this.endRent = end;
    }


}

