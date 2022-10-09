package com.example.clickcounterapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnPlus;
    private TextView counter;
    private Button btnMinus;

    public boolean Prim(int szam) {
        boolean prim = false;
        if (szam >= 2){
            for (int i = 2; i <= szam / 2; i++) {
                if (szam % i == 0) {
                    prim = true;
                    break;
                }
            }
        }
        return prim;
    };

    public void Counter() {
        btnPlus = findViewById(R.id.buttonPlus);
        counter = findViewById(R.id.textViewCounter);
        btnMinus = findViewById(R.id.buttonMinus);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int szam = Integer.parseInt(counter.getText().toString()) + 1;
                counter.setText(String.valueOf(szam));
                if (szam < 0) {
                    counter.setTextColor(Color.rgb(255, 0, 0));
                }
                else if (szam == 0) {
                    counter.setTextColor(Color.parseColor("#0000ff"));
                }
                else if (!Prim(szam) && szam != 1){
                    counter.setTextColor(Color.parseColor("#ffffff"));
                }
                else {
                    counter.setTextColor(Color.parseColor("#228c22"));
                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int szam = Integer.parseInt(counter.getText().toString()) - 1;
                counter.setText(String.valueOf(szam));
                if (szam < 0) {
                    counter.setTextColor(Color.rgb(255, 0, 0));
                }
                else if (szam == 0) {
                    counter.setTextColor(Color.parseColor("#0000ff"));
                }
                else if (!Prim(szam) && szam != 1){
                    counter.setTextColor(Color.parseColor("#ffffff"));
                }
                else {
                    counter.setTextColor(Color.parseColor("#228c22"));
                }
            }
        });

        counter.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                counter.setText("0");
                counter.setTextColor(Color.parseColor("#0000ff"));
                return false;
            }
        });


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Counter();

    }
}