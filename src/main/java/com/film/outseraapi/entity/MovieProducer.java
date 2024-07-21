package com.film.outseraapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="movie_producer")
public class MovieProducer {

    @Id
    @Column(name="idMovieProducer")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idMovieProducer;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Producer producer;

    public MovieProducer() {
    }

    public MovieProducer(Movie movie, Producer producer) {
        this.movie = movie;
        this.producer = producer;
    }

    public Integer getIdMovieProducer() {
        return idMovieProducer;
    }

    public void setIdMovieProducer(Integer idMovieProducer) {
        this.idMovieProducer = idMovieProducer;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
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
