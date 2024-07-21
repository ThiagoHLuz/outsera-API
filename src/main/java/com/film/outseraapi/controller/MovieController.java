package com.film.outseraapi.controller;

import com.film.outseraapi.dto.MovieDTO;
import com.film.outseraapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovie(@PathVariable(name="id") Integer id) {
        MovieDTO movieDTO = movieService.getMovie(id);

        HttpStatus status = HttpStatus.OK;
        if ( movieDTO == null ) {
            status = HttpStatus.NO_CONTENT;
        }

        return new ResponseEntity<>(movieDTO, status);
    }

}
