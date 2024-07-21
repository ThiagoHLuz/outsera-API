package com.film.outseraapi.dto;

import com.film.outseraapi.entity.Movie;
import com.film.outseraapi.entity.MovieProducer;
import com.film.outseraapi.entity.MovieStudio;

import java.util.ArrayList;
import java.util.List;

public class MovieDTO {

    private Integer id;

    private Integer year;

    private String title;

    private List<String> studios = new ArrayList<>();

    private List<String> producers = new ArrayList<>();

    private Boolean winner;

    public MovieDTO() {
    }

    public MovieDTO(Movie movie) {
        this.id = movie.getIdMovie();
        this.year = movie.getYear();
        this.title = movie.getTitle();
        this.winner = movie.getWinner();

        for (MovieStudio movieStudio : movie.getStudios()) {
            this.studios.add(movieStudio.getStudio().getName());
        }

        for (MovieProducer movieProducer : movie.getProducers()) {
            this.producers.add(movieProducer.getProducer().getName());
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<String> getStudios() {
        return studios;
    }

    public void setStudios(List<String> studios) {
        this.studios = studios;
    }

    public List<String> getProducers() {
        return producers;
    }

    public void setProducers(List<String> producers) {
        this.producers = producers;
    }

    public Boolean getWinner() {
        return winner;
    }

    public void setWinner(Boolean winner) {
        this.winner = winner;
    }
}
