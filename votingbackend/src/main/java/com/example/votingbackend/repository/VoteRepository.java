package com.example.votingbackend.repository;

import com.example.votingbackend.model.Vote;
import com.example.votingbackend.model.VoteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, VoteId> {

    // JpaRepository automatically provides these methods:
    //
    // Basic CRUD Operations:
    // - save(Vote vote) - Insert or Update vote
    // - findAll() - Get all votes
    // - findById(VoteId id) - Get vote by composite ID
    // - deleteById(VoteId id) - Delete vote by ID
    // - delete(Vote vote) - Delete vote entity
    // - count() - Count total votes
    // - existsById(VoteId id) - Check if vote exists
    //
    // No additional methods needed for basic functionality
    // Spring Data JPA handles everything automatically!
}
