package com.example.t00600236.memeory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class choosingPictureActivity extends AppCompatActivity {
    Intent intent;

    boolean p1=false, p2=false;
    public static String name1,name2;//picture name

    public static String p1name,p2name;
    public static TextView p1nametxtvw;
    public static TextView p2nametxtvw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing_picture);
        //intent= getIntent();

        ImageView img1 = findViewById(R.id.img1);
        ImageView img2 = findViewById(R.id.img2);

        //get name input textview
        p1nametxtvw=findViewById(R.id.name1TextView);
        p2nametxtvw=findViewById(R.id.name2TextView);







        img1.setImageResource(R.drawable.meme1);
        img2.setImageResource(R.drawable.meme2);
    }



    public void onChoosePic1(View view){
        p1=true;
        name1="meme1";
        Toast.makeText(getApplicationContext(),"c1", Toast.LENGTH_SHORT ).show();
    }

    public void onChoosePic2(View view){
        p2=true;
        name2="meme2";
        Toast.makeText(getApplicationContext(),"c2", Toast.LENGTH_SHORT ).show();
    }

    public void toPlay(View view){
        p1name=p1nametxtvw.getText().toString();
        p2name=p2nametxtvw.getText().toString();
        if(p1==false||p2==false) {
            Toast.makeText(getApplicationContext(),"Please choose the picture!", Toast.LENGTH_SHORT ).show();
            return;
        }
            intent = new Intent(this, playActivity.class);
            startActivityForResult(intent, MainActivity.SECOND_ACTIVITY_REQUEST_CODE);

    }
}
