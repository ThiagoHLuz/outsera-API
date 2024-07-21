package com.film.outseraapi.repository;

import com.film.outseraapi.entity.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long> {

    Producer findByName(String name);
}
