package com.sambit.TicTacToe;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class NameActivity extends AppCompatActivity {

    public CharSequence player1 = "1";
    public CharSequence player2 = "2";
    private int length;
    public boolean selectedsingleplayer = true;
    private EditText nameAi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Util.blackIconStatusBar(NameActivity.this, R.color.light_backgroud);


        Window w = getWindow(); // in Activity's onCreate() for instance
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_name);

        nameAi = findViewById(R.id.player_name_ai);


        nameAi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                player1 = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                length = nameAi.getText().length();

            }
        }, 0, 2);//put here time 1000 milliseconds = 1 second


        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if (length > 1) {

                    Button ds = findViewById(R.id.button2);
                    ds.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(NameActivity.this, ChooseActivity.class);
                            CharSequence[] players = {player1, player2};
                            i.putExtra("playersnames", players);
                            i.putExtra("selectedsingleplayer", selectedsingleplayer);
                            startActivity(i);
                        }
                    });

                }


            }
        }, 0, 20);//put here time 1000 milliseconds = 1 second


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(NameActivity.this, MainActivity.class);
        startActivity(intent);
    }
}