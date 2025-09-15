package com.example.votingbackend.repository;

import com.example.votingbackend.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {}
