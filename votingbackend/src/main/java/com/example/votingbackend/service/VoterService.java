package com.example.votingbackend.service;

import com.example.votingbackend.model.Voter;
import com.example.votingbackend.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterService {

    @Autowired
    private VoterRepository voterRepository;

    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    public Voter addVoter(Voter voter) {
        return voterRepository.save(voter);
    }
}
