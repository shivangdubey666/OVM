package com.example.votingbackend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vote")
@IdClass(VoteId.class)
public class Vote {

    @Id
    @Column(name = "Voter_ID")  // ✅ Uppercase to match database
    private Integer voterId;

    @Id
    @Column(name = "Election_ID")  // ✅ Uppercase
    private Integer electionId;

    @ManyToOne
    @JoinColumn(name = "Candidate_ID", referencedColumnName = "Candidate_ID")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "Election_ID", referencedColumnName = "Election_ID", insertable = false, updatable = false)
    private Election election;

    @ManyToOne
    @JoinColumn(name = "Voter_ID", referencedColumnName = "Voter_ID", insertable = false, updatable = false)
    private Voter voter;

    @Column(name = "Vote_Date")  // ✅ Uppercase
    private LocalDateTime voteDate;

    // Constructors
    public Vote() {}

    // Getters and Setters
    public Integer getVoterId() {
        return voterId;
    }

    public void setVoterId(Integer voterId) {
        this.voterId = voterId;
    }

    public Integer getElectionId() {
        return electionId;
    }

    public void setElectionId(Integer electionId) {
        this.electionId = electionId;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    public Voter getVoter() {
        return voter;
    }

    public void setVoter(Voter voter) {
        this.voter = voter;
    }

    public LocalDateTime getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(LocalDateTime voteDate) {
        this.voteDate = voteDate;
    }
}
