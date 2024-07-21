package com.film.outseraapi.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="movie")
public class Movie {

    @Id
    @Column(name="idMovie")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idMovie;

    @Column(name="year_movie")
    private Integer year;

    @Column(name="title")
    private String title;

    @Column(name="winner")
    private Boolean winner;

    @OneToMany(mappedBy="movie", cascade= CascadeType.ALL, orphanRemoval = true, fetch= FetchType.EAGER)
    private Set<MovieStudio> studios = new HashSet<>();

    @OneToMany(mappedBy="movie", cascade=CascadeType.ALL, orphanRemoval = true, fetch=FetchType.EAGER)
    private Set<MovieProducer> producers = new HashSet<>();

    public Movie() { }

    public Movie(Integer year, String title, String winner) {
        this.year = year;
        this.title = title.trim();
        this.winner = (winner != null && "yes".equalsIgnoreCase(winner.trim())) ;
    }
    public void setIdMovie(Integer idMovie) {
        this.idMovie = idMovie;
    }

    public Integer getIdMovie() {
        return idMovie;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getWinner() {
        return winner;
    }

    public void setWinner(Boolean winner) {
        this.winner = winner;
    }

    public Set<MovieStudio> getStudios() {
        return studios;
    }

    public void setStudios(Set<MovieStudio> studios) {
        this.studios = studios;
    }

    public Set<MovieProducer> getProducers() {
        return producers;
    }

    public void setProducers(Set<MovieProducer> producers) {
        this.producers = producers;
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
