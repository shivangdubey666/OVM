package com.example.votingbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "party")
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Party_ID")
    private int partyId;

    @Column(name = "Name")
    private String name;

    // Getters and setters
    public int getPartyId() { return partyId; }
    public void setPartyId(int partyId) { this.partyId = partyId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
