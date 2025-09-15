package com.example.votingbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "candidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Candidate_ID")
    private int candidateId;

    @Column(name = "Name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Party_ID")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Party party;

    @Column(name = "Position")
    private String position;

    @Column(name = "Campaign_Info")
    private String campaignInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Election_ID")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Election election;

    // Getters and setters

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCampaignInfo() {
        return campaignInfo;
    }

    public void setCampaignInfo(String campaignInfo) {
        this.campaignInfo = campaignInfo;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }
}
