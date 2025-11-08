package com.example.votingbackend.service;

import com.example.votingbackend.model.Candidate;
import com.example.votingbackend.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    // ✅ Register candidate (default: not approved)
    public void registerCandidate(Candidate candidate) {
        candidate.setApproved(false);  // Default: approval pending
        candidateRepository.save(candidate);
    }

    // ✅ Get all candidates
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    // ✅ Get all pending candidates (is_approved = false)
    public List<Candidate> getPendingCandidates() {
        return candidateRepository.findByIsApprovedFalse();
    }

    // ✅ Approve candidate by ID
    public void approveCandidate(Integer id) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found with ID: " + id));
        candidate.setApproved(true);
        candidateRepository.save(candidate);
    }

    // ✅ Reject candidate (delete from database)
    public void rejectCandidate(Integer id) {
        candidateRepository.deleteById(id);
    }
}
