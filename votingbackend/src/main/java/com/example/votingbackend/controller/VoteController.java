package com.example.votingbackend.controller;

import com.example.votingbackend.model.Vote;
import com.example.votingbackend.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votes")
@CrossOrigin(origins = "*")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @PostMapping("/cast")
    public String castVote(@RequestBody Vote vote) {
        try {
            voteService.castVote(vote);
            return "Vote cast successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
