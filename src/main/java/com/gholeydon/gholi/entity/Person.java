package com.gholeydon.gholi.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@NamedQueries({
        @NamedQuery(name = "findAllPerson",query = "select p from Person p"),
        @NamedQuery(name = "findPersonByNationalCode",query = "select p from Person p where p.nationalcode=: nationalCode")
})

@Entity
public class Person {
    private Long id;
    private String name ;
    private String family;
    private String nationalcode ;
    private LocalDate birthDay;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "NAME",nullable = false,unique = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getNationalcode() {
        return nationalcode;
    }
    public void setNationalcode(String nationalcode) {
        this.nationalcode = nationalcode;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "entity.Person{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", nationalcode='" + nationalcode + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) || Objects.equals(family, person.family) || Objects.equals(nationalcode, person.nationalcode) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, family, nationalcode, birthDay);
    }
}