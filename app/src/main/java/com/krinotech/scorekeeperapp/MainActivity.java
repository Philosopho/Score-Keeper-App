package com.krinotech.scorekeeperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Team teamA;
    private Team teamB;

    private TextView teamAScore;
    private TextView teamBScore;
    private Button teamATouchdown;
    private Button teamBTouchdown;
    private Button teamAFieldGoal;
    private Button teamBFieldGoal;
    private Button teamASafety;
    private Button teamBSafety;
    private Button teamAExtraPoint;
    private Button teamBExtraPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamA = new Team();
        teamB = new Team();

        teamAScore = findViewById(R.id.first_score);
        teamATouchdown = findViewById(R.id.first_touchdown);
        teamASafety = findViewById(R.id.first_safety);
        teamAExtraPoint = findViewById(R.id.first_extra_point);
        teamAFieldGoal = findViewById(R.id.first_field_goal);
        Button resetButton = findViewById(R.id.reset);

        teamBScore = findViewById(R.id.second_score);
        teamBTouchdown = findViewById(R.id.second_touchdown);
        teamBSafety = findViewById(R.id.second_safety);
        teamBExtraPoint = findViewById(R.id.second_extra_point);
        teamBFieldGoal = findViewById(R.id.second_field_goal);

        teamATouchdown.setOnClickListener(touchDownScore(teamA, teamAScore));
        teamASafety.setOnClickListener(safetyScore(teamA, teamAScore));
        teamAExtraPoint.setOnClickListener(extraPointScore(teamA, teamAScore));
        teamAFieldGoal.setOnClickListener(fieldGoalScore(teamA, teamAScore));

        teamBTouchdown.setOnClickListener(touchDownScore(teamB, teamBScore));
        teamBSafety.setOnClickListener(safetyScore(teamB, teamBScore));
        teamBExtraPoint.setOnClickListener(extraPointScore(teamB, teamBScore));
        teamBFieldGoal.setOnClickListener(fieldGoalScore(teamB, teamBScore));

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScoreTracker.resetScores(teamA, teamB);
                setScore(teamAScore, teamA);
                setScore(teamBScore, teamB);
            }
        });
    }

    private View.OnClickListener safetyScore(final Team team, final TextView scoreBoard) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScoreTracker.safety(team);
                setScore(scoreBoard, team);
            }
        };
    }

    private void setScore(TextView scoreBoard, Team team) {
        scoreBoard.setText(String.valueOf(team.getScore()));
    }

    private View.OnClickListener extraPointScore(final Team team, final TextView scoreBoard) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScoreTracker.extraPoint(team);
                setScore(scoreBoard, team);
            }
        };
    }

    private View.OnClickListener fieldGoalScore(final Team team, final TextView scoreBoard) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScoreTracker.fieldGoal(team);
                setScore(scoreBoard, team);
            }
        };
    }

    private View.OnClickListener touchDownScore(final Team team, final TextView scoreBoard) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScoreTracker.touchdown(team);
                setScore(scoreBoard, team);
            }
        };
    }
}
