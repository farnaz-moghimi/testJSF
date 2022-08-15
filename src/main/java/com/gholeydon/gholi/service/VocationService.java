package com.gholeydon.gholi.service;



import com.gholeydon.gholi.dao.DataStore;
import com.gholeydon.gholi.dao.VocationDao;
import com.gholeydon.gholi.entity.Person;
import com.gholeydon.gholi.entity.Vocation;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.time.LocalDate;

import java.util.List;
import java.util.Scanner;


@RequestScoped
public class VocationService {
    @Inject
    VocationDao vocationDao;
    PersonService personService;
    public void createVocation() {

        vocationDao.createVocation();


        Scanner vocationScanner = new Scanner(System.in);

        System.out.println("Please Insert Date of vacation");
        String dateVacation = vocationScanner.nextLine();

        PersonService personService = new PersonService();
        Person p = personService.SearchPerson();
        System.out.println(p.hashCode());

        Vocation v = new Vocation();
        v.setDate(LocalDate.now());
        v.setDuration();
        v.setPerson(p);

        vocationDao.insertVocation(v);


        //DataStore.add(v);
        System.out.println(v);
    }

    public Vocation searchVocation() {
        Scanner searachScannner = new Scanner(System.in);
        System.out.println("Please Insert Your Date");

        String dateString = searachScannner.nextLine(); // 2016-08-16

        LocalDate localDate = LocalDate.parse(dateString);

        List<Vocation> vocationList = DataStore.findAllVocation();
        for (Vocation v : vocationList) {
            if (v.getDate().equals(localDate)) {
                return v;
            }

        }
        return null;
    }

}
