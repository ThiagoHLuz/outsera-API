package com.film.outseraapi.repository;

import com.film.outseraapi.entity.MovieStudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieStudioRepository extends JpaRepository<MovieStudio, Long> {
}
