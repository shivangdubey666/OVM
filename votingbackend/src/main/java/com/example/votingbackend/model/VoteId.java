package com.example.votingbackend.model;

import java.io.Serializable;
import java.util.Objects;

public class VoteId implements Serializable {

    private int voterId;
    private int electionId;

    public VoteId() {}

    public VoteId(int voterId, int electionId) {
        this.voterId = voterId;
        this.electionId = electionId;
    }

    public int getVoterId() { return voterId; }
    public void setVoterId(int voterId) { this.voterId = voterId; }

    public int getElectionId() { return electionId; }
    public void setElectionId(int electionId) { this.electionId = electionId; }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof VoteId)) return false;
        VoteId that = (VoteId) o;
        return voterId==that.voterId && electionId==that.electionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(voterId, electionId);
    }
}
