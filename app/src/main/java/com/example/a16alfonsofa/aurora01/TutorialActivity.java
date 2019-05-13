package com.example.a16alfonsofa.aurora01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a16alfonsofa.aurora01.Pantallas.MainActivity;

public class TutorialActivity extends AppCompatActivity {

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);


        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(TutorialActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
