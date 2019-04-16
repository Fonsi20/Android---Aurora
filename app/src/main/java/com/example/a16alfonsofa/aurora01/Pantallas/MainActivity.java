package com.example.a16alfonsofa.aurora01.Pantallas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.a16alfonsofa.aurora01.R;

public class MainActivity extends AppCompatActivity {

    private ImageView btn1, btn2, btn3, btn_Abrir_Popup, btnprofile;
    private CardView btn4;
    private Button btn_Cerrar;
    private LayoutInflater layoutInflater;
    private View popupView;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btn_Abrir_Popup = (ImageView) findViewById(R.id.btn_sos);
        btnprofile = (ImageView) findViewById(R.id.profile);
        btn1 = (ImageView) findViewById(R.id.button1);
        btn2 = (ImageView) findViewById(R.id.button2);
        btn3 = (ImageView) findViewById(R.id.button3);
        btn4 = (CardView) findViewById(R.id.button4);


        btn1.setImageResource(R.mipmap.ic_happy_uncolor);
        btn2.setImageResource(R.mipmap.ic_neutral_uncolor);
        btn3.setImageResource(R.mipmap.ic_sad_uncolor);

        btn1.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                btn2.setImageResource(R.mipmap.ic_neutral_uncolor);
                btn3.setImageResource(R.mipmap.ic_sad_uncolor);
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        btn1.setImageResource(R.mipmap.ic_happy_uncolor);
                        break;
                    case MotionEvent.ACTION_UP:
                        btn1.setImageResource(R.mipmap.ic_happy_color);
                        break;
                }
                return true;
            }
        });

        btn2.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                btn1.setImageResource(R.mipmap.ic_happy_uncolor);
                btn3.setImageResource(R.mipmap.ic_sad_uncolor);
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        btn2.setImageResource(R.mipmap.ic_neutral_uncolor);
                        break;
                    case MotionEvent.ACTION_UP:
                        btn2.setImageResource(R.mipmap.ic_neutro_color);
                        break;
                }
                return true;
            }
        });

        btn3.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                btn1.setImageResource(R.mipmap.ic_happy_uncolor);
                btn2.setImageResource(R.mipmap.ic_neutral_uncolor);
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        btn3.setImageResource(R.mipmap.ic_sad_uncolor);
                        break;
                    case MotionEvent.ACTION_UP:
                        btn3.setImageResource(R.mipmap.ic_sad_color);
                        break;
                }
                return true;
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ActividadIndividual.class);
                startActivity(i);
            }
        });

        btnprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ListaActividad.class);
                startActivity(i);
            }
        });


        btn_Abrir_Popup.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(MainActivity.this, AyudaActivity.class);
                startActivity(i);
            }
        });
    }
}

