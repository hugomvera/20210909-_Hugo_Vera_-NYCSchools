package com.whitemanx.NYCSchools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Scores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        // math_avg

        Bundle bundle = getIntent().getExtras();

        //for names
        String message1 = bundle.getString("name");
        TextView txtView2 = (TextView) findViewById(R.id.schoolName);
        txtView2.setText( message1);




        //for math avg
        String message2= bundle.getString("math_avg");
        TextView txtView3 = (TextView) findViewById(R.id.mathScore);
        txtView3.setText(message2);


        //for written avg
       String message3= bundle.getString("write_avg");
        TextView txtView4 = (TextView) findViewById(R.id.verbalScore);
        txtView4.setText(  message3);


        //for written avg
        String message4= bundle.getString("critical_avg");
        TextView txtView5 = (TextView) findViewById(R.id.scoreCritical);
        txtView5.setText(  message4);


        //for critical avg
         String message5= bundle.getString("website");
        TextView txtView6 = (TextView) findViewById(R.id.website);
        txtView6.setText( message5);


        //phone
        String message6= bundle.getString("phone");
        TextView txtView7 = (TextView) findViewById(R.id.phone);
        txtView7.setText( message6);


        //phone
        String message7= bundle.getString("numStudents");
        TextView txtView8 = (TextView) findViewById(R.id.numStudents);
        txtView8.setText( message7);

    }
}