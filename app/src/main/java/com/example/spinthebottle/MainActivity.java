package com.example.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        bottle.animate().rotation(spinAngle).setDuration(2000);
    }

}
