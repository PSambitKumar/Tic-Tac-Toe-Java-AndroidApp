package com.sambit.TicTacToe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class ChooseActivity extends AppCompatActivity {

    CharSequence player1 = "Player 1";
    CharSequence player2 = "Player 2";
    public boolean selectedsingleplayer;


    boolean player1ax, isSelected, isFirstChoose;

    private String shape;
    private ImageView joker, venom, spider, hulk, dead, iron;
    private TextView label;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        Window w = getWindow(); // in Activity's onCreate() for instance
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final SharedPreferences sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);


        CharSequence[] players = getIntent().getCharSequenceArrayExtra("playersnames");
        player1 = players[0];
        player2 = players[1];

        label = findViewById(R.id.label);

        selectedsingleplayer = getIntent().getBooleanExtra("selectedsingleplayer", true);
        if (!selectedsingleplayer) {
            label.setText(player1 + " pick your side");
        } else {
            label.setText("Pick your side");
        }

        spider = findViewById(R.id.spider);
        iron = findViewById(R.id.iron);
        hulk = findViewById(R.id.hulk);
        dead = findViewById(R.id.dead);
        venom = findViewById(R.id.venom);
        joker = findViewById(R.id.joker);

        spider.setColorFilter(getApplicationContext().getResources().getColor(R.color.transparent));
        iron.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
        dead.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
        hulk.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
        venom.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
        joker.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));

        iron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelected = true;
                player1ax = false;
                shape = "iron";
                iron.setColorFilter(getApplicationContext().getResources().getColor(R.color.transparent));
                spider.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
                dead.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
                hulk.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
                venom.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
                joker.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
            }
        });

        spider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelected = true;
                player1ax = true;
                shape = "spider";
                spider.setColorFilter(getApplicationContext().getResources().getColor(R.color.transparent));
                iron.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
                dead.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
                hulk.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
                venom.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
                joker.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
            }
        });

        hulk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelected = true;
                player1ax = false;
                shape = "hulk";
                hulk.setColorFilter(getApplicationContext().getResources().getColor(R.color.transparent));
                iron.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
                dead.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
                spider.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
                venom.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
                joker.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
            }
        });

        dead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelected = true;
                player1ax = true;
                shape = "star";
                dead.setColorFilter(getApplicationContext().getResources().getColor(R.color.transparent));
                iron.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
                hulk.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
                spider.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
                venom.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
                joker.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
            }
        });

        venom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelected = true;
                player1ax = true;
                shape = "triangle";
                venom.setColorFilter(getApplicationContext().getResources().getColor(R.color.transparent));
                dead.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
                spider.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
                hulk.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
                joker.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
                iron.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
            }
        });

        joker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelected = true;
                player1ax = false;
                shape = "square";
                joker.setColorFilter(getApplicationContext().getResources().getColor(R.color.transparent));
                dead.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
                spider.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
                venom.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
                hulk.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
                iron.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
            }
        });

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (isSelected) {
                    Button ds = findViewById(R.id.button);
                    ds.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            CharSequence[] players1 = getIntent().getCharSequenceArrayExtra("playersnames");
                            player1 = players1[0];
                            player2 = players1[1];
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            if (!isFirstChoose) {
                                editor.putString("first", shape);
                                editor.apply();

                                clearAll(shape);
                                isFirstChoose = true;
                            } else {
                                editor.putString("second", shape);
                                editor.apply();

                                Intent i = new Intent(ChooseActivity.this, SceneActivity.class);
                                CharSequence[] players = {player1, player2};
                                i.putExtra("playersnames", players);
                                //i.putExtra("player1ax", player1ax);
                                i.putExtra("selectedsingleplayer", selectedsingleplayer);
                                startActivity(i);
                            }
                        }
                    });
                }
            }


        }, 0, 20);//put here time 1000 milliseconds = 1 second


    }

    private void clearAll(String shape) {
        timer.cancel();
        this.shape = "";

        if (!selectedsingleplayer) {
            label.setText(player2 + " pick your side");
        } else {
            label.setText("Pick AI side");
        }

        spider.setColorFilter(getApplicationContext().getResources().getColor(R.color.transparent));
        iron.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
        dead.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
        hulk.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
        venom.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));
        joker.setColorFilter(getApplicationContext().getResources().getColor(R.color.tint2));

        switch (shape) {
            case "o":
                spider.setEnabled(false);
                break;
            case "x":
                hulk.setEnabled(false);
                break;
            case "poly":
                iron.setEnabled(false);
                break;
            case "triangle":
                venom.setEnabled(false);
                break;
            case "square":
                joker.setEnabled(false);
                break;
            case "star":
                dead.setEnabled(false);
                break;
        }

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ChooseActivity.this, NameActivity.class);
        startActivity(intent);
    }
}
