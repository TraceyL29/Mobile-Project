package com.example.t00600236.memeory;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class playActivity extends AppCompatActivity {

    ArrayList<Integer> allPictures = new ArrayList<Integer>();
    ArrayList<Integer> player1 = new ArrayList<Integer>();
    ArrayList<Integer> player2 = new ArrayList<Integer>();
    Random rand = new Random();
    ImageView img0, img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14, img15;

    ImageView img0a, img1a, img2a, img3a, img4a, img5a, img6a, img7a, img8a, img9a, img10a, img11a, img12a, img13a, img14a, img15a;

    TextView txt1, txt2, time;
    Timer T;
    String p1 = "", p2 = "";
    int tag1, tag2;
    int count = 0, timeCounter=0;
    int p1Remain = 4, p2Remain = 4;
    public static String winner,winnerTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        img0 = (ImageView) findViewById(R.id.image0);
        img1 = findViewById(R.id.image1);
        img2 = findViewById(R.id.image2);
        img3 = findViewById(R.id.image3);
        img4 = findViewById(R.id.image4);
        img5 = findViewById(R.id.image5);
        img6 = findViewById(R.id.image6);
        img7 = findViewById(R.id.image7);
        img8 = findViewById(R.id.image8);
        img9 = findViewById(R.id.image9);
        img10 = findViewById(R.id.image10);
        img11 = findViewById(R.id.image11);
        img12 = findViewById(R.id.image12);
        img13 = findViewById(R.id.image13);
        img14 = findViewById(R.id.image14);
        img15 = findViewById(R.id.image15);


        img0a = findViewById(R.id.image0a);
        img1a = findViewById(R.id.image1a);
        img2a = findViewById(R.id.image2a);
        img3a = findViewById(R.id.image3a);
        img4a = findViewById(R.id.image4a);
        img5a = findViewById(R.id.image5a);
        img6a = findViewById(R.id.image6a);
        img7a = findViewById(R.id.image7a);
        img8a = findViewById(R.id.image8a);
        img9a = findViewById(R.id.image9a);
        img10a = findViewById(R.id.image10a);
        img11a = findViewById(R.id.image11a);
        img12a = findViewById(R.id.image12a);
        img13a = findViewById(R.id.image13a);
        img14a = findViewById(R.id.image14a);
        img15a = findViewById(R.id.image15a);

        for (int i = 0; i < 16; i++) {
            allPictures.add(i);
        }

        txt1 = findViewById(R.id.player1Button);
        txt2 = findViewById(R.id.player2Button);
        time = findViewById(R.id.timeTextView);
        distribute();
        setTime();
        img0a.setImageResource(R.drawable.mem3);
        img1a.setImageResource(R.drawable.mem3);
        img2a.setImageResource(R.drawable.mem3);
        img3a.setImageResource(R.drawable.mem3);
        img4a.setImageResource(R.drawable.mem3);
        img5a.setImageResource(R.drawable.mem3);
        img6a.setImageResource(R.drawable.mem3);
        img7a.setImageResource(R.drawable.mem3);
        img8a.setImageResource(R.drawable.mem3);
        img9a.setImageResource(R.drawable.mem3);
        img10a.setImageResource(R.drawable.mem3);
        img11a.setImageResource(R.drawable.mem3);
        img12a.setImageResource(R.drawable.mem3);
        img13a.setImageResource(R.drawable.mem3);
        img14a.setImageResource(R.drawable.mem3);
        img15a.setImageResource(R.drawable.mem3);


        txt1.setText(choosingPictureActivity.p1name + ": " + p1Remain);
        txt2.setText(choosingPictureActivity.p2name + ": " + p2Remain);

    }


    //set time
    public void setTime() {
        T = new Timer();
        T.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
            runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    int minute=0;
                    if(timeCounter<=60)
                        if(timeCounter<10)
                        time.setText("Time: 00:0"+timeCounter);
                        else
                            time.setText("Time: 00:"+timeCounter);
                    else if(timeCounter>60) {
                        minute= timeCounter/60;
                        if(timeCounter%60<10)
                        time.setText("Time: "+minute+":0"+timeCounter%60);
                        else
                            time.setText("Time: "+minute+":"+timeCounter%60);
                    }
                    timeCounter++;
                    winnerTime= (minute+":"+timeCounter%60).toString();
                }
            });
        }
    }, 1000, 1000);
    }

    //stop Time
    public void stopTime(){
        T.cancel();
    }










    public void distribute(){
       int count=0;
       while(count<16){

           int choosen1= rand.nextInt(allPictures.size());
           player1.add(allPictures.get(choosen1));
           allPictures.remove(allPictures.get(choosen1));

           int choosen2= rand.nextInt(allPictures.size());
           player2.add(allPictures.get(choosen2));
           allPictures.remove(allPictures.get(choosen2));

           count+=2;
       }

       for(int i=0; i<player1.size(); i++){
           choosePicture(player1.get(i),choosingPictureActivity.name1);
           p1+=player1.get(i)+" ";
       }

        for(int i=0; i<player2.size(); i++){
            choosePicture(player2.get(i),choosingPictureActivity.name2);
            Toast.makeText(getApplicationContext(),choosingPictureActivity.name2, Toast.LENGTH_SHORT ).show();
            p2+=player2.get(i)+" ";
        }

        //String x1,x2;
        //x1=String.valueOf(player1.size());
        //x2=String.valueOf(player2.size());

    }

    private void checkPair(int tag){

                    count++;
                    if(count==1){
                        tag1=tag;
                        Toast.makeText(getApplicationContext(), String.valueOf(tag1), Toast.LENGTH_SHORT).show();
                        //state=true;
                    }
                    if (count==2){

                        tag2=tag;
                        Toast.makeText(getApplicationContext(), String.valueOf(tag2), Toast.LENGTH_SHORT).show();
                        //todo


                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Do something after 100ms
                        Toast.makeText(getApplicationContext(), "flip", Toast.LENGTH_SHORT).show();
                        if(checkSimilar(tag1,tag2)==true){}
                         else{
                            flip(tag1);
                            flip(tag2);
                            tag1=-1;
                            tag2=-1;
                        }
                    }
                }, 80);



            }

        //Toast.makeText(getApplicationContext(), String.valueOf(count), Toast.LENGTH_SHORT).show();

        if(count==2)count=0;



    }

    private void flip(int tag){
        switch(tag){
            case 0:
                img0a.setVisibility(View.VISIBLE);
                break;
            case 1:
                img1a.setVisibility(View.VISIBLE);
                break;
            case 2:
                img2a.setVisibility(View.VISIBLE);
                break;
            case 3:
                img3a.setVisibility(View.VISIBLE);
                break;
            case 4:
                img4a.setVisibility(View.VISIBLE);
                break;
            case 5:
                img5a.setVisibility(View.VISIBLE);
                break;
            case 6:
                img6a.setVisibility(View.VISIBLE);
                break;
            case 7:
                img7a.setVisibility(View.VISIBLE);
                break;
            case 8:
                img8a.setVisibility(View.VISIBLE);
                break;
            case 9:
                img9a.setVisibility(View.VISIBLE);
                break;
            case 10:
                img10a.setVisibility(View.VISIBLE);
                break;
            case 11:
                img11a.setVisibility(View.VISIBLE);
                break;
            case 12:
                img12a.setVisibility(View.VISIBLE);
                break;
            case 13:
                img13a.setVisibility(View.VISIBLE);
                break;
            case 14:
                img14a.setVisibility(View.VISIBLE);
                break;
            case 15:
                img15a.setVisibility(View.VISIBLE);
                break;
                default:
                    Toast.makeText(getApplicationContext(), "no tag", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private boolean checkSimilar(int tag1, int tag2){
        if(player1.contains(tag1)&&player1.contains(tag2)){
            p1Remain--;
            txt1.setText(choosingPictureActivity.p1name+": "+p1Remain);
            winCondition();
            return true;
        }
        else if (player2.contains(tag1)&&player2.contains(tag2)){
            p2Remain--;
            txt2.setText(choosingPictureActivity.p2name+": "+p2Remain);
            winCondition();
            return true;
        }
        else
            return false;

    }

    private void winCondition(){
        if(p1Remain==0||p2Remain==0){
            if(p1Remain==0) {
                Toast.makeText(getApplicationContext(), "p1 wins", Toast.LENGTH_SHORT).show();
                //show big image
                stopTime();
                winner= choosingPictureActivity.p1name;

            }
            if(p2Remain==0){
                Toast.makeText(getApplicationContext(), "p2 wins", Toast.LENGTH_SHORT).show();
                //show big image
                stopTime();
                winner= choosingPictureActivity.p1name;
            }

        }
    }

    public void onImage0a(View view){


        img0a.setVisibility(View.INVISIBLE);

        checkPair(0);



    }

    public void onImage1a(View view){


        img1a.setVisibility(View.INVISIBLE);


        checkPair(1);



    }

    public void onImage2a(View view){

        img2a.setVisibility(View.INVISIBLE);
        Toast.makeText(getApplicationContext(), "Eureka", Toast.LENGTH_SHORT).show();

        checkPair(2);
    }

    public void onImage3a(View view){

        img3a.setVisibility(View.INVISIBLE);
        Toast.makeText(getApplicationContext(), "Eureka", Toast.LENGTH_SHORT).show();
        checkPair(3);

    }

    public void onImage4a(View view){

        img4a.setVisibility(View.INVISIBLE);
        Toast.makeText(getApplicationContext(), "Eureka", Toast.LENGTH_SHORT).show();
        checkPair(4);

    }

    public void onImage5a(View view){

        img5a.setVisibility(View.INVISIBLE);
        Toast.makeText(getApplicationContext(), "Eureka", Toast.LENGTH_SHORT).show();
        checkPair(5);

    }

    public void onImage6a(View view){

        img6a.setVisibility(View.INVISIBLE);
        Toast.makeText(getApplicationContext(), "Eureka", Toast.LENGTH_SHORT).show();
        checkPair(6);

    }

    public void onImage7a(View view){

        img7a.setVisibility(View.INVISIBLE);
        Toast.makeText(getApplicationContext(), "Eureka", Toast.LENGTH_SHORT).show();
        checkPair(7);

    }

    public void onImage8a(View view){

        img8a.setVisibility(View.INVISIBLE);
        Toast.makeText(getApplicationContext(), "Eureka", Toast.LENGTH_SHORT).show();
        checkPair(8);

    }

    public void onImage9a(View view){

        img9a.setVisibility(View.INVISIBLE);
        Toast.makeText(getApplicationContext(), "Eureka", Toast.LENGTH_SHORT).show();
        checkPair(9);

    }

    public void onImage10a(View view){

        img10a.setVisibility(View.INVISIBLE);
        Toast.makeText(getApplicationContext(), "Eureka", Toast.LENGTH_SHORT).show();
        checkPair(10);

    }

    public void onImage11a(View view){

        img11a.setVisibility(View.INVISIBLE);
        Toast.makeText(getApplicationContext(), "Eureka", Toast.LENGTH_SHORT).show();
        checkPair(11);

    }

    public void onImage12a(View view){

        img12a.setVisibility(View.INVISIBLE);
        Toast.makeText(getApplicationContext(), "Eureka", Toast.LENGTH_SHORT).show();
        checkPair(12);

    }

    public void onImage13a(View view){

        img13a.setVisibility(View.INVISIBLE);
        Toast.makeText(getApplicationContext(), "Eureka", Toast.LENGTH_SHORT).show();
        checkPair(13);

    }

    public void onImage14a(View view){

        img14a.setVisibility(View.INVISIBLE);
        Toast.makeText(getApplicationContext(), "Eureka", Toast.LENGTH_SHORT).show();
        checkPair(14);

    }

    public void onImage15a(View view){

        img15a.setVisibility(View.INVISIBLE);
        Toast.makeText(getApplicationContext(), "Eureka", Toast.LENGTH_SHORT).show();
        checkPair(15);

    }





   public void choosePicture(Integer position, String pictureName){
        switch (position){
            case 0:
                if(pictureName.compareTo("meme1")==0){
                    img0.setImageResource(R.drawable.meme1);
                }
                else if(pictureName.equals("meme2")){
                    img0.setImageResource(R.drawable.meme2);
                }
                break;
            case 1:
                if(pictureName.equals("meme1")){
                    img1.setImageResource(R.drawable.meme1);
                }
                else if(pictureName.equals("meme2")) {
                    img1.setImageResource(R.drawable.meme2);
                }
                break;
            case 2:
                if(pictureName.equals("meme1"))
                    img2.setImageResource(R.drawable.meme1);
                else img2.setImageResource(R.drawable.meme2);
                break;
            case 3:
                if(pictureName.equals("meme1"))
                    img3.setImageResource(R.drawable.meme1);
                else img3.setImageResource(R.drawable.meme2);
                break;
            case 4:
                if(pictureName.equals("meme1"))
                    img4.setImageResource(R.drawable.meme1);
                else img4.setImageResource(R.drawable.meme2);
                break;
            case 5:
                if(pictureName.equals("meme1"))
                    img5.setImageResource(R.drawable.meme1);
                else img5.setImageResource(R.drawable.meme2);
                break;
            case 6:
                if(pictureName.equals("meme1"))
                    img6.setImageResource(R.drawable.meme1);
                else img6.setImageResource(R.drawable.meme2);
                break;
            case 7:
                if(pictureName.equals("meme1"))
                    img7.setImageResource(R.drawable.meme1);
                else img7.setImageResource(R.drawable.meme2);
                break;
            case 8:
                if(pictureName.equals("meme1"))
                    img8.setImageResource(R.drawable.meme1);
                else img8.setImageResource(R.drawable.meme2);
                break;
            case 9:
                if(pictureName.equals("meme1"))
                    img9.setImageResource(R.drawable.meme1);
                else img9.setImageResource(R.drawable.meme2);
                break;
            case 10:
                if(pictureName.equals("meme1"))
                    img10.setImageResource(R.drawable.meme1);
                else img10.setImageResource(R.drawable.meme2);
                break;
            case 11:
                if(pictureName.equals("meme1"))
                    img11.setImageResource(R.drawable.meme1);
                else img11.setImageResource(R.drawable.meme2);
                break;
            case 12:
                if(pictureName.equals("meme1"))
                    img12.setImageResource(R.drawable.meme1);
                else img12.setImageResource(R.drawable.meme2);
                break;
            case 13:
                if(pictureName.equals("meme1"))
                    img13.setImageResource(R.drawable.meme1);
                else img13.setImageResource(R.drawable.meme2);
                break;
            case 14:
                if(pictureName.equals("meme1"))
                    img14.setImageResource(R.drawable.meme1);
                else img14.setImageResource(R.drawable.meme2);
                break;
            case 15:
                if(pictureName.equals("meme1"))
                    img15.setImageResource(R.drawable.meme1);
                else img15.setImageResource(R.drawable.meme2);
                break;

            }
    }




}
