package com.gholeydon.gholi.service;



import com.gholeydon.gholi.dao.DataStore;
import com.gholeydon.gholi.dao.PersonDao;
import com.gholeydon.gholi.entity.Person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RequestScoped
public class PersonService {

    @Inject
    PersonDao personDao;

    public void createPersonnel(Person person) {
       // personDao.createPerson();

        /*Person person = new Person();

        Scanner input = new Scanner(System.in);

        System.out.println("Enter your name");
        String name = input.nextLine();
        System.out.println("name :" + name);

        System.out.println("Enter your family");
        String family = input.nextLine();
        System.out.println("family : " + family);

        System.out.println("Enter your nationalcode");
        String nationalcode = input.nextLine();
        System.out.println("nationalcode : " + nationalcode);

        System.out.println("Enter your birthDay");
        String birthDay = input.nextLine();
        System.out.println("birthDay : " + birthDay);


        person.setName(name);
        person.setFamily(family);
        person.setNationalcode(nationalcode);
        person.setBirthDay(LocalDate.now());
*/
        personDao.insertPerson(person);


/*
            if (DataStore.findAllPerson().contains(person)) {
               // personDao.createPerson(person);
                System.out.println(person);
            }else {
                System.out.println("");
            }
*/

    }

    public Person SearchPerson() {
        Scanner serachScannner = new Scanner(System.in);
        System.out.println("Please Insert NationalCode");
        String nationalCode = serachScannner.nextLine();

        List<Person> personList = personDao.findAllPerson();
        for (Person p:personList) {
            System.out.println(p);
        }
        return personDao.findPerson(nationalCode);

       /* List<Person> personList = DataStore.findAllPerson();
        for (Person p : personList) {
            if (p.getNationalcode().equals(nationalCode)) {
                return p;
            }
        }*/
    }

    public List<Person> findAllPerson(){
        return personDao.findAllPerson();
    }


    public boolean IsDublicate(Person person) {
        List<Person> personList = DataStore.findAllPerson();
        for (Person p : personList) {
            if (p.equals(person)) {
                return true;
            }
        }

        for (int i = 0; i < personList.size(); i++) {
            Person p = personList.get(i);
            if (p.getNationalcode().equals(person.getNationalcode())) {
                return true;
            }
        }
        return false;
    }

}
