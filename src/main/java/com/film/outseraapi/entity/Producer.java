package com.film.outseraapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Producer")
public class Producer {

    @Id
    @Column(name="idProducer")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idProducer;

    @Column(name="name", nullable=false)
    private String name;

    public Producer() {}

    public Producer(String name) {
        this.name = name.trim();
    }

    public Integer getIdProducer() {
        return idProducer;
    }

    public void setIdProducer(Integer id) {
        this.idProducer = id;
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
