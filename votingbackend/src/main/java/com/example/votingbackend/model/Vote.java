package com.example.votingbackend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@IdClass(VoteId.class)
@Table(name = "vote")
public class Vote {

    @Id
    @Column(name = "voter_id")
    private int voterId;

    @Id
    @Column(name = "candidate_id")
    private int candidateId;

    @Column(name = "election_id")
    private int electionId;

    @Column(name = "vote_date")
    private LocalDateTime voteDate;

    // Getters and Setters

    public int getVoterId() {
        return voterId;
    }
    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }
    public int getCandidateId() {
        return candidateId;
    }
    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }
    public int getElectionId() {
        return electionId;
    }
    public void setElectionId(int electionId) {
        this.electionId = electionId;
    }
    public LocalDateTime getVoteDate() {
        return voteDate;
    }
    public void setVoteDate(LocalDateTime voteDate) {
        this.voteDate = voteDate;
    }
}
