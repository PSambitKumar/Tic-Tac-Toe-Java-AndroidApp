package com.sambit.TicTacToe;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class TwoNameActivity extends AppCompatActivity {

    public CharSequence player1 = "Player 1";
    public CharSequence player2 = "Player 2";
    public boolean selectedsingleplayer = false;
    private EditText first;
    private EditText second;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_two_name);


        final Button button = findViewById(R.id.button2);
        final ImageView imageView = findViewById(R.id.imageView4);
        SoftKeyboardStateHelper.SoftKeyboardStateListener softKeyboardStateListener = new SoftKeyboardStateHelper.SoftKeyboardStateListener() {
            @Override
            public void onSoftKeyboardOpened(int keyboardHeightInPx) {
                imageView.setVisibility(View.GONE);

                button.setVisibility(View.GONE);

            }

            @Override
            public void onSoftKeyboardClosed() {
                imageView.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
            }
        };

        final SoftKeyboardStateHelper softKeyboardStateHelper = new SoftKeyboardStateHelper(getApplicationContext(), findViewById(R.id.parent));
        softKeyboardStateHelper.addSoftKeyboardStateListener(softKeyboardStateListener);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        first = findViewById(R.id.first_player);
        first.addTextChangedListener(new TextWatcher() {
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

        second = findViewById(R.id.second_player);
        second.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                player2 = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        Button ds = findViewById(R.id.button2);
        ds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TwoNameActivity.this, ChooseActivity.class);
                i.putExtra("selectedsingleplayer", selectedsingleplayer);
                CharSequence[] players = {player1, player2};
                i.putExtra("playersnames", players);

                startActivity(i);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(TwoNameActivity.this, MainActivity.class);
        startActivity(intent);
    }
}