package com.example.votingbackend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vote")
@IdClass(VoteId.class) // composite key class
public class Vote {
    @Id
    @Column(name = "Voter_ID")
    private int voterId;

    @Id
    @Column(name = "Election_ID")
    private int electionId;

    @Column(name = "Candidate_ID")
    private int candidateId;

    @Column(name = "Vote_Date")
    private LocalDateTime voteDate;

    // Getters/Setters
    public int getVoterId() { return voterId; }
    public void setVoterId(int voterId) { this.voterId = voterId; }

    public int getElectionId() { return electionId; }
    public void setElectionId(int electionId) { this.electionId = electionId; }

    public int getCandidateId() { return candidateId; }
    public void setCandidateId(int candidateId) { this.candidateId = candidateId; }

    public LocalDateTime getVoteDate() { return voteDate; }
    public void setVoteDate(LocalDateTime voteDate) { this.voteDate = voteDate; }
}
