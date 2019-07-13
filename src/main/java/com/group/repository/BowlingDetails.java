package com.group.repository;

public class BowlingDetails {
    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Float getOvers() {
        return overs;
    }

    public void setOvers(Float overs) {
        this.overs = overs;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public Integer getWicket() {
        return wicket;
    }

    public void setWicket(Integer wicket) {
        this.wicket = wicket;
    }

    private String playerId;
    private Float overs;
    private Integer marks;
    private Integer wicket;
}
