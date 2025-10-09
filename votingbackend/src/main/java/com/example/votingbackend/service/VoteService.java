package com.example.votingbackend.service;

import com.example.votingbackend.model.Vote;
import com.example.votingbackend.repository.VoteRepository;
import com.example.votingbackend.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VoteService {

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    VoterRepository voterRepository;

    public boolean hasVoted(int voterId, int electionId){
        return voteRepository.existsByVoterIdAndElectionId(voterId, electionId);
    }

    public Vote castVote(Vote vote) throws Exception {
        if(!voterRepository.existsById(vote.getVoterId())){
            throw new Exception("Invalid Voter");
        }

        if(voteRepository.existsByVoterIdAndElectionId(vote.getVoterId(), vote.getElectionId())){
            throw new Exception("Already Voted");
        }

        vote.setVoteDate(LocalDateTime.now());
        return voteRepository.save(vote);
    }
}
