package com.example.votingbackend.service;

import com.example.votingbackend.model.*;
import com.example.votingbackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    public void castVote(Vote vote) {
        voteRepository.save(vote);
    }

    public List<Map<String, Object>> getResults(Integer electionId) {
        List<Vote> votes = voteRepository.findAll();

        // Group by candidate and count votes for the given election
        Map<Candidate, Long> voteCounts = votes.stream()
                .filter(vote -> vote.getElection().getElectionId() == electionId)
                .collect(Collectors.groupingBy(Vote::getCandidate, Collectors.counting()));

        // Convert to list of maps
        return voteCounts.entrySet().stream()
                .map(entry -> {
                    Map<String, Object> result = new HashMap<>();
                    result.put("candidateId", entry.getKey().getCandidateId());
                    result.put("candidateName", entry.getKey().getName());
                    result.put("voteCount", entry.getValue());
                    return result;
                })
                .collect(Collectors.toList());
    }
}
