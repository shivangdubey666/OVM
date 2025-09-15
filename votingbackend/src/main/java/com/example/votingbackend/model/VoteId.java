package com.example.votingbackend.model;

import java.io.Serializable;
import java.util.Objects;

public class VoteId implements Serializable {

    private int voterId;
    private int candidateId;

    public VoteId() {}

    public VoteId(int voterId, int candidateId) {
        this.voterId = voterId;
        this.candidateId = candidateId;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof VoteId)) return false;
        VoteId voteId = (VoteId) o;
        return voterId == voteId.voterId && candidateId == voteId.candidateId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(voterId, candidateId);
    }
}
