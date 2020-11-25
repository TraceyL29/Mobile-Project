package com.example.t00600236.memeory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    Intent intent;
    public static final int SECOND_ACTIVITY_REQUEST_CODE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.playButton);
    }

    public void goToChoosingPictureActivity(View v) {
            intent = new Intent(this, choosingPictureActivity.class);
            startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);

    }
}
