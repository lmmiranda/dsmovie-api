package com.devsuperior.dsmovieapi.services;

import com.devsuperior.dsmovieapi.dto.MovieDTO;
import com.devsuperior.dsmovieapi.entites.Movie;
import com.devsuperior.dsmovieapi.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable) {
        Page<Movie> moviePage = movieRepository.findAll(pageable);
        Page<MovieDTO> movieDTOPage = moviePage.map(movie -> new MovieDTO(movie));
        return movieDTOPage;
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id) {
        Movie movie = movieRepository.findById(id).get();
        MovieDTO movieDTO = new MovieDTO(movie);
        return movieDTO;
    }
}
