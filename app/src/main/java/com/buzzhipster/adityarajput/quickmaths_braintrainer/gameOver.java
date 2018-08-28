package com.buzzhipster.adityarajput.quickmaths_braintrainer;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;



public class gameOver extends Activity {
    int highscoreOrg;
    int newHighScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        TextView currentScore = findViewById(R.id.scoreView);
        TextView noofques = findViewById(R.id.highScoreView);
        Button playAgain = findViewById(R.id.tryAgainButton);
        TextView questionss = findViewById(R.id.questions);

        //getting high-score from shared preferances and comparing it with new high-score
        SharedPreferences highScoresp = this.getSharedPreferences("com.buzzhipster.adityarajput.quickmaths_braintrainer" , Context.MODE_PRIVATE);
        highscoreOrg = highScoresp.getInt("highScore" , 0);
        //

        //getting score from intent

        int score = getIntent().getIntExtra("score" , 0);
        int questions = getIntent().getIntExtra("questions" , 0);
        int correct = getIntent().getIntExtra("correct" , 0);
        currentScore.setText("Your Score : " + Integer.toString(score));

        //setting highscore
        if(score > highscoreOrg) {
            highScoresp.edit().putInt("highScore", score).apply();
            highscoreOrg = score;
            noofques.setText("New High Score : " + highscoreOrg);
        }

        else
        {
            noofques.setText("High Score : " + highscoreOrg);
        }
        //

        questionss.setText("Correct :" + Integer.toString(correct));

    }
    public void playAgainm(View view){
        startActivity(new Intent(getApplicationContext(), GameActivity.class));
    }
    public void goHome(View view){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
