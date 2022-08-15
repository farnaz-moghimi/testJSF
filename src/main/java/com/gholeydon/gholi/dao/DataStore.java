package com.gholeydon.gholi.dao;



import com.gholeydon.gholi.entity.Person;
import com.gholeydon.gholi.entity.Vocation;

import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class DataStore {
    private static List<Person> personList = new ArrayList<>();
    private static List<Vocation> vocationList = new ArrayList<>();



    public static void add(Person person){
        personList.add(person);
    }
    public static void add(Vocation vocation){
        vocationList.add(vocation);
    }
    public static List<Person> findAllPerson(){
        return personList;
    }
    public static List<Vocation> findAllVocation(){
        return vocationList;
    }
}
