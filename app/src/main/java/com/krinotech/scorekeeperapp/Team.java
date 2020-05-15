package com.krinotech.scorekeeperapp;

class Team {

    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void increaseScore(int points) {
        this.score += points;
    }
}
