package com.group.repository;

public class MatchDetails {
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountryOne() {
        return countryOne;
    }

    public void setCountryOne(String countryOne) {
        this.countryOne = countryOne;
    }

    public String getCountryTwo() {
        return countryTwo;
    }

    public void setCountryTwo(String countryTwo) {
        this.countryTwo = countryTwo;
    }

    public String getWinningCountry() {
        return winningCountry;
    }

    public void setWinningCountry(String winningCountry) {
        this.winningCountry = winningCountry;
    }

    public String getManOfTheMatch() {
        return manOfTheMatch;
    }

    public void setManOfTheMatch(String manOfTheMatch) {
        this.manOfTheMatch = manOfTheMatch;
    }

    private String date;
    private String countryOne;
    private String countryTwo;
    private String winningCountry;
    private String manOfTheMatch;
}
