package com.example.votingbackend.repository;

import com.example.votingbackend.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Integer> {

    Voter findByEmail(String email);

    // ✅ NEW: Get all pending voters (is_approved = false)
    List<Voter> findByIsApprovedFalse();

    // ✅ OPTIONAL: Get all approved voters
    List<Voter> findByIsApprovedTrue();
}
