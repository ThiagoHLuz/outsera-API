package com.film.outseraapi.repository;

import com.film.outseraapi.entity.MovieProducer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieProducerRepository extends JpaRepository<MovieProducer, Long> {

    @Query("SELECT mp " +
           "FROM MovieProducer mp " +
           "JOIN mp.movie movie " +
           "JOIN mp.producer producer " +
           "WHERE movie.winner = :isWinner " +
           "ORDER BY producer.idProducer, movie.year")
    List<MovieProducer> findByMovieWinnerOrderByProducerId(@Param("isWinner") Boolean isWinner);
}
