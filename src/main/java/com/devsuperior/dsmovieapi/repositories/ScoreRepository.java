package com.devsuperior.dsmovieapi.repositories;

import com.devsuperior.dsmovieapi.entites.Score;
import com.devsuperior.dsmovieapi.entites.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}
