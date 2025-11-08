package com.example.votingbackend.controller;

import com.example.votingbackend.model.Candidate;
import com.example.votingbackend.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
// ❌ DELETE THIS LINE: @CrossOrigin(origins = "*")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping("/register")
    public ResponseEntity<String> registerCandidate(@RequestBody Candidate candidate) {
        candidateService.registerCandidate(candidate);
        return ResponseEntity.ok("Candidate registered successfully, pending admin approval");
    }

    @GetMapping
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        List<Candidate> candidates = candidateService.getAllCandidates();
        return ResponseEntity.ok(candidates);
    }

    @GetMapping("/pending")
    public ResponseEntity<List<Candidate>> getPendingCandidates() {
        List<Candidate> pendingCandidates = candidateService.getPendingCandidates();
        return ResponseEntity.ok(pendingCandidates);
    }

    @PutMapping("/approve/{id}")
    public ResponseEntity<String> approveCandidate(@PathVariable Integer id) {
        candidateService.approveCandidate(id);
        return ResponseEntity.ok("Candidate approved successfully");
    }

    @DeleteMapping("/reject/{id}")
    public ResponseEntity<String> rejectCandidate(@PathVariable Integer id) {
        candidateService.rejectCandidate(id);
        return ResponseEntity.ok("Candidate rejected successfully");
    }
}
