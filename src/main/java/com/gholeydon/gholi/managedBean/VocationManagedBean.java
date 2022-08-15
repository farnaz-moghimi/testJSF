package com.gholeydon.gholi.managedBean;

import com.gholeydon.gholi.entity.Person;
import com.gholeydon.gholi.entity.Vocation;
import com.gholeydon.gholi.service.VocationService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.List;

@Named
@RequestScoped
public class VocationManagedBean {
    private Long id;
    private LocalDate date;
    private Long duration;
    private String person;



    @Inject
    VocationService vocationService;

    List<Vocation>vocationList;


    public void create(){
        Vocation v =new Vocation();
        v.setDate(LocalDate.now());
        v.setDuration();
        Person p = new Person();
        v.setPerson(p);
    }



    public List<Vocation> getVocationList() {
        return vocationList;
    }

    public void setVocationList(List<Vocation> vocationList) {
        this.vocationList = vocationList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
