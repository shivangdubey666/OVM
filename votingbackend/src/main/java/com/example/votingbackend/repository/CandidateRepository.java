package com.example.votingbackend.repository;

import com.example.votingbackend.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    // ✅ Find all candidates where is_approved = false
    List<Candidate> findByIsApprovedFalse();
}
