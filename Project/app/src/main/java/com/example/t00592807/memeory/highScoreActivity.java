package com.example.t00600236.memeory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.auth.*;

public class highScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
    }

    public void saveUserInformation(){
        String name= playActivity.winner;
        String time= playActivity.winnerTime;
        UserInformation user = new UserInformation(name, time);



    }
}
