package com.film.outseraapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="studio")
public class Studio {

    @Id
    @Column(name="idStudio")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idStudio;

    @Column(name="name", unique=true)
    private String name;

    public Studio() {
    }

    public Studio(String name) {
        this.name = name.trim();
    }

    public Integer getIdStudio() {
        return idStudio;
    }

    public void setIdStudio(Integer id) {
        this.idStudio = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
