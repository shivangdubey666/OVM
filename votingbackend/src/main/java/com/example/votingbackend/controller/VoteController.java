package com.example.votingbackend.controller;

import com.example.votingbackend.model.Vote;
import com.example.votingbackend.service.VoteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votes")
@CrossOrigin(origins = {"http://localhost:8081", "http://127.0.0.1:5500"}, allowCredentials = "true")

public class VoteController {
    @Autowired
    private VoteService voteService;

    @PostMapping("/cast")
    public String castVote(@RequestBody Vote vote, HttpSession session) {
        Integer voterId = (Integer) session.getAttribute("voterId");
        if (voterId == null) {
            return "Please login first";
        }
        vote.setVoterId(voterId);
        try {
            voteService.castVote(vote);
            return "Vote cast successfully";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
