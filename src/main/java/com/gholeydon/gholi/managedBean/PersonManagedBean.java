package com.gholeydon.gholi.managedBean;

import com.gholeydon.gholi.entity.Person;
import com.gholeydon.gholi.service.PersonService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class PersonManagedBean {

    @Inject
    private PersonService personService;

    private String name;
    private String family;
    private String nationalcode;

    List<Person> personList;

    @PostConstruct
    public void init(){
       personList =new ArrayList<>();
       personList = personService.findAllPerson();

    }


    public String create(){
        Person p = new Person();
        p.setName(name);
        p.setFamily(family);
        p.setNationalcode(nationalcode);
        p.setBirthDay(LocalDate.now());
        personService.createPersonnel(p);
        name=family=nationalcode=null;
        init();
        return "";
    }
    //getter & setter
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

    public List<Person> getPersonList() {
        return personList;
    }
    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

}
