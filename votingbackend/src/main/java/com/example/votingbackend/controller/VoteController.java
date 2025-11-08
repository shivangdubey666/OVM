package com.example.votingbackend.controller;

import com.example.votingbackend.model.*;
import com.example.votingbackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/votes")
//@CrossOrigin(origins = "*")
public class VoteController {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private VoterRepository voterRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private ElectionRepository electionRepository;

    @PostMapping("/cast")
    public ResponseEntity<String> castVote(@RequestBody Map<String, Integer> voteData) {
        Integer voterId = voteData.get("voterId");
        Integer candidateId = voteData.get("candidateId");
        Integer electionId = voteData.get("electionId");

        // Fetch entities
        Voter voter = voterRepository.findById(voterId).orElse(null);
        Candidate candidate = candidateRepository.findById(candidateId).orElse(null);
        Election election = electionRepository.findById(electionId).orElse(null);

        if (voter == null || candidate == null || election == null) {
            return ResponseEntity.badRequest().body("Invalid voter, candidate, or election ID");
        }

        // ✅ PREVENT SECOND VOTE IN SAME ELECTION
        VoteId voteId = new VoteId(voterId, electionId);
        boolean alreadyVoted = voteRepository.existsById(voteId);
        if (alreadyVoted) {
            return ResponseEntity.badRequest().body("Already Voted");
        }

        // Create vote
        Vote vote = new Vote();
        vote.setVoter(voter);
        vote.setCandidate(candidate);
        vote.setElection(election);
        vote.setVoterId(voter.getVoterId());
        vote.setElectionId(election.getElectionId());
        vote.setVoteDate(java.time.LocalDateTime.now());

        voteRepository.save(vote);

        return ResponseEntity.ok("Vote cast successfully");
    }
}
