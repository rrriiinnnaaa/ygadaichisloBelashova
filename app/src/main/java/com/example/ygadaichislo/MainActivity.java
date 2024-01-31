package com.example.ygadaichislo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvInfo;
    private EditText etInput;
    private Button bControl;
    private int guess;
    private boolean gameFinished;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = findViewById(R.id.textView);
        etInput = findViewById(R.id.editTextNumber);
        bControl = findViewById(R.id.button);
        guess = (int)(Math.random()*100);
        gameFinished = false;

    }

    public void onClick(View v)
    {
        if(!gameFinished) {
            int inp = Integer.parseInt(etInput.getText().toString());
            String str = Integer.toString(inp);
            if (inp > guess)
                tvInfo.setText("Перелет!");
                etInput.setText("");
            if (inp < guess)
                tvInfo.setText("Недолет!");
                etInput.setText("");
            if (inp == guess) {
                tvInfo.setText("В точку!");
                etInput.setText(Integer.toString(inp));
                bControl.setText("Сыграть еще");
                gameFinished = true;
            }
        }
        else
        {
            guess = (int)(Math.random()*100);
            bControl.setText("Ввести значение: ");
            tvInfo.setText("Попробуйте угадать число (1 - 100)");
            gameFinished = false;
            etInput.setText("");
        }

    }
}