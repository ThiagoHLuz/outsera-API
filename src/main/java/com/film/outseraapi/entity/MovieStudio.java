package com.film.outseraapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="movie_studio")
public class MovieStudio {

    @Id
    @Column(name="idMovieStudio")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idMovieStudio;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Studio studio;

    public MovieStudio() {
    }

    public MovieStudio(Movie movie, Studio studio) {
        this.movie = movie;
        this.studio = studio;
    }

    public Integer getIdMovieStudio() {
        return idMovieStudio;
    }

    public void setIdMovieStudio(Integer idMovieStudio) {
        this.idMovieStudio = idMovieStudio;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
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
