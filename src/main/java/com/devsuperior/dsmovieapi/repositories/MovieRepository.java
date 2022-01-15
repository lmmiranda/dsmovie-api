package com.devsuperior.dsmovieapi.repositories;

import com.devsuperior.dsmovieapi.entites.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
