package com.group.repository;

public class BattingDetail {

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Integer getRuns() {
        return runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

    public Integer getBalls() {
        return balls;
    }

    public void setBalls(Integer balls) {
        this.balls = balls;
    }

    public Integer getFours() {
        return fours;
    }

    public void setFours(Integer fours) {
        this.fours = fours;
    }

    public Integer getSixs() {
        return sixs;
    }

    public void setSixs(Integer sixs) {
        this.sixs = sixs;
    }

    private String playerId;
    private Integer runs;
    private Integer balls;
    private Integer fours;
    private Integer sixs;


}
