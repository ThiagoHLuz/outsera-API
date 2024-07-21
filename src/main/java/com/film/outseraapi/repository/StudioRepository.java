package com.film.outseraapi.repository;

import com.film.outseraapi.entity.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Long> {

    Studio findByName(String name);
}
