package com.film.outseraapi.service;

import com.film.outseraapi.dto.MovieDTO;
import com.film.outseraapi.entity.Movie;
import com.film.outseraapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public MovieDTO getMovie(Integer id){

        Movie movie = movieRepository.findByIdMovie(id);
        if (movie == null) {
            return new MovieDTO();
        }
        return new MovieDTO(movie);
    }
}
