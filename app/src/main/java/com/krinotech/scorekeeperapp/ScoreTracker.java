package com.krinotech.scorekeeperapp;

public class ScoreTracker {
    public static final int SAFETY = 2;
    public static final int TOUCHDOWN = 7;
    public static final int EXTRA_POINT = 1;
    public static final int FIELD_GOAL = 3;

    public static void resetScores(Team... teams) {
        for(Team team: teams) {
            team.setScore(0);
        }
    }

    public static void safety(Team team) {
        team.increaseScore(SAFETY);
    }

    public static void touchdown(Team team) {
        team.increaseScore(TOUCHDOWN);
    }

    public static void extraPoint(Team team) {
        team.increaseScore(EXTRA_POINT);
    }

    public static void fieldGoal(Team team) {
        team.increaseScore(FIELD_GOAL);
    }
}
