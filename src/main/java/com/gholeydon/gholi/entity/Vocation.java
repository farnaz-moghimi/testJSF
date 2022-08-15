package com.gholeydon.gholi.entity;


import java.time.LocalDate;
import java.util.Objects;

public class Vocation {

    private Long id;
    private LocalDate date;
    private Long duration;
    private Person person;

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

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "entity.Vocation Information{" +
                "date=" + date +
                ", person=" + person.hashCode() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vocation vocation = (Vocation) o;
        return Objects.equals(date, vocation.date) && Objects.equals(person, vocation.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, person);
    }


    public void setDuration() {
    }
}
