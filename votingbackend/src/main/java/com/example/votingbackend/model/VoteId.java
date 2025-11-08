package com.example.votingbackend.model;

import java.io.Serializable;
import java.util.Objects;

public class VoteId implements Serializable {

    private int voterId;     // ✅ Must match Vote class field name
    private int electionId;  // ✅ Must match Vote class field name

    // Default constructor
    public VoteId() {}

    // Parameterized constructor
    public VoteId(int voterId, int electionId) {
        this.voterId = voterId;
        this.electionId = electionId;
    }

    // Getters and setters
    public int getVoterId() { return voterId; }
    public void setVoterId(int voterId) { this.voterId = voterId; }

    public int getElectionId() { return electionId; }
    public void setElectionId(int electionId) { this.electionId = electionId; }

    // equals() and hashCode() are MANDATORY for composite keys
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteId voteId = (VoteId) o;
        return voterId == voteId.voterId && electionId == voteId.electionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(voterId, electionId);
    }
}
