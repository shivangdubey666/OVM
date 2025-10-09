package com.example.votingbackend.repository;

import com.example.votingbackend.model.Vote;
import com.example.votingbackend.model.VoteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, VoteId> {
    boolean existsByVoterIdAndElectionId(int voterId, int electionId);
}
