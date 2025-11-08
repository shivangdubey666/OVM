package com.example.votingbackend.controller;

import com.example.votingbackend.model.Voter;
import com.example.votingbackend.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/voters")
public class VoterController {

    @Autowired
    private VoterService voterService;

    @PostMapping("/register")
    public ResponseEntity<String> registerVoter(@RequestBody Voter voter) {
        voterService.registerVoter(voter);
        return ResponseEntity.ok("Voter registered successfully, pending admin approval");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginVoter(@RequestBody Voter loginRequest) {
        Voter voter = voterService.findByEmail(loginRequest.getEmail());

        if (voter == null) {
            return ResponseEntity.badRequest().body("Voter not found");
        }

        if (!voter.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid password");
        }

        if (!voter.isApproved()) {
            return ResponseEntity.badRequest().body("Your account is pending admin approval");
        }

        // ✅ Return voter data with voterId
        Map<String, Object> response = new HashMap<>();
        response.put("voterId", voter.getVoterId());
        response.put("name", voter.getName());
        response.put("email", voter.getEmail());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/pending")
    public ResponseEntity<List<Voter>> getPendingVoters() {
        List<Voter> pendingVoters = voterService.getPendingVoters();
        return ResponseEntity.ok(pendingVoters);
    }

    @PutMapping("/approve/{id}")
    public ResponseEntity<String> approveVoter(@PathVariable Integer id) {
        voterService.approveVoter(id);
        return ResponseEntity.ok("Voter approved successfully");
    }

    @DeleteMapping("/reject/{id}")
    public ResponseEntity<String> rejectVoter(@PathVariable Integer id) {
        voterService.rejectVoter(id);
        return ResponseEntity.ok("Voter rejected successfully");
    }
}
