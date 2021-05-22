package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int counter = 0;
    Button inc, dec, snd;
    TextView text;
    final String TAG = "wari";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState!=null)
        {
            counter = savedInstanceState.getInt("COUNTER", 0);
        }
        setContentView(R.layout.activity_main);
        inc = findViewById(R.id.increment);
        dec = findViewById(R.id.decrement);
        snd = findViewById(R.id.send);
        text = findViewById(R.id.textView);

        text.setText(counter + "");
        inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                      counter++;
                      text.setText(counter + "");

            }
        });

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                text.setText(counter + "");

            }
        });
        snd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("COUNTER", counter);

                startActivity(intent);


            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("COUNTER",counter);
    }
}

