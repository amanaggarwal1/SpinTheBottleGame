package com.example.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText players;
    private ImageView bottle;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        players = findViewById(R.id.playersET);
        bottle = findViewById(R.id.bottleIV);
        result = findViewById(R.id.resultTV);

        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(players.getText().toString().isEmpty())
                    Toast.makeText(MainActivity.this, "Please enter the players", Toast.LENGTH_SHORT).show();
                else
                    spinBottle();
            }
        });

    }


    private void spinBottle(){
        Random random = new Random();
        int spinAngle = random.nextInt(3600) + 1;
        int effectiveAngle = spinAngle % 360;

        //result.animate().alpha(0).setDuration(500);
        bottle.animate().rotation(spinAngle).setDuration(2500);

        int numberOfPlayers = Integer.parseInt(players.getText().toString());
        int segmentSize = 360 / numberOfPlayers;
        effectiveAngle = ( effectiveAngle + (segmentSize / 2) ) % 360;
        int position =  ( effectiveAngle / segmentSize ) + 1;

        final String output = "Player " + position + "'s Turn";
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                result.setText(output);
            }
        }, 2500);
    }

}
