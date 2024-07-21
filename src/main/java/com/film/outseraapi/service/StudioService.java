package com.film.outseraapi.service;

import com.film.outseraapi.entity.Movie;
import com.film.outseraapi.entity.MovieStudio;
import com.film.outseraapi.entity.Studio;
import com.film.outseraapi.repository.MovieStudioRepository;
import com.film.outseraapi.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class StudioService {

    @Autowired
    private StudioRepository studioRepository;

    @Autowired
    private MovieStudioRepository movieStudioRepository;

    public void saveStudios(Movie movie, String studios) {
        for (String strStudio : studios.split(",|\\ and ")) {
            Studio studio = new Studio(strStudio);

            Example<Studio> example = Example.of(studio);

            if (studioRepository.exists(example)) {
                studio = studioRepository.findByName(strStudio.trim());
            } else {
                studio = studioRepository.save(studio);
            }

            movieStudioRepository.save(new MovieStudio(movie, studio));
        }
    }
}
