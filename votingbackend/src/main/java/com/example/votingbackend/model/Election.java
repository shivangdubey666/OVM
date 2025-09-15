package com.example.votingbackend.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "election")
public class Election {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Election_ID")
    private int electionId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Date")
    private Date date;

    // Getters and setters
    public int getElectionId() { return electionId; }
    public void setElectionId(int electionId) { this.electionId = electionId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
}
