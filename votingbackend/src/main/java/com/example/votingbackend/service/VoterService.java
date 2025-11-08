package com.example.votingbackend.service;

import com.example.votingbackend.model.Voter;
import com.example.votingbackend.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterService {

    @Autowired
    private VoterRepository voterRepository;

    // ✅ Register voter (default: not approved)
    public void registerVoter(Voter voter) {
        voter.setApproved(false);  // Default: approval pending
        voterRepository.save(voter);
    }

    // ✅ Find voter by email
    public Voter findByEmail(String email) {
        return voterRepository.findByEmail(email);
    }

    // ✅ NEW: Get all pending voters (is_approved = false)
    public List<Voter> getPendingVoters() {
        return voterRepository.findByIsApprovedFalse();
    }

    // ✅ NEW: Approve voter by ID
    public void approveVoter(Integer id) {
        Voter voter = voterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Voter not found with ID: " + id));
        voter.setApproved(true);
        voterRepository.save(voter);
    }

    // ✅ NEW: Reject voter (delete from database)
    public void rejectVoter(Integer id) {
        voterRepository.deleteById(id);
    }
}
