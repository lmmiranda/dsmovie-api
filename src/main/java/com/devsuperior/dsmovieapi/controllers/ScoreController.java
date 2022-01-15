package com.devsuperior.dsmovieapi.controllers;

import com.devsuperior.dsmovieapi.dto.MovieDTO;
import com.devsuperior.dsmovieapi.dto.ScoreDTO;
import com.devsuperior.dsmovieapi.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PutMapping
    public MovieDTO save(@RequestBody ScoreDTO scoreDTO) {
        return scoreService.save(scoreDTO);
    }
}
