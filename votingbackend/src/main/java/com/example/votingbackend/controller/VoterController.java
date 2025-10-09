package com.example.votingbackend.controller;

import com.example.votingbackend.model.Voter;
import com.example.votingbackend.repository.VoterRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voter")
@CrossOrigin(origins = "http://localhost:8081", allowCredentials = "true")
public class VoterController {
    @Autowired
    private VoterRepository voterRepository;

    @PostMapping("/login")
    public String login(@RequestBody Voter voter, HttpSession session) {
        Voter dbVoter = voterRepository.findByEmailAndPasswordAndIsApprovedTrue(
                voter.getEmail(), voter.getPassword());
        if (dbVoter != null) {
            session.setAttribute("voterId", dbVoter.getVoterId());
            return "Login successful";
        } else {
            return "Invalid login or approval pending";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "Logged out";
    }
}
