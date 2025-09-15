package com.example.votingbackend.controller;

import com.example.votingbackend.model.Candidate;
import com.example.votingbackend.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidates")
@CrossOrigin(origins = "*")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @GetMapping("/all")
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }
}
