package com.devsuperior.dsmovieapi.services;

import com.devsuperior.dsmovieapi.dto.MovieDTO;
import com.devsuperior.dsmovieapi.dto.ScoreDTO;
import com.devsuperior.dsmovieapi.entites.Movie;
import com.devsuperior.dsmovieapi.entites.Score;
import com.devsuperior.dsmovieapi.entites.User;
import com.devsuperior.dsmovieapi.repositories.MovieRepository;
import com.devsuperior.dsmovieapi.repositories.ScoreRepository;
import com.devsuperior.dsmovieapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO save(ScoreDTO scoreDTO) {
        User user = userRepository.findByEmail(scoreDTO.getEmail());

        if (ObjectUtils.isEmpty(user)) {
            user = new User();
            user.setEmail(scoreDTO.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();

        Score scoreToSave = new Score();

        scoreToSave.setMovie(movie);
        scoreToSave.setUser(user);
        scoreToSave.setValue(scoreDTO.getScore());

        scoreToSave = scoreRepository.saveAndFlush(scoreToSave);

        double sum = 0.0;
        for (Score score:
                movie.getScores()) {
            sum = sum + score.getValue();
        }

        double averageScore = sum / movie.getScores().size();
        movie.setScore(averageScore);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);
        return new MovieDTO(movie);
    }
}
