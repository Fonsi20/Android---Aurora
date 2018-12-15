package com.example.a16alfonsofa.aurora01.Pantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.*;
import android.widget.*;

import com.example.a16alfonsofa.aurora01.R;

public class MainActivity extends AppCompatActivity {

    private ImageView btn1, btn2, btn3;
    private ImageButton btn_Abrir_Popup;
    private Button btn_Cerrar;
    private LayoutInflater layoutInflater;
    private View popupView;
    private PopupWindow popupWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Abrir_Popup = (ImageButton) findViewById(R.id.btn_sos);
        btn1 = (ImageView) findViewById(R.id.button1);
        btn2 = (ImageView) findViewById(R.id.button2);
        btn3 = (ImageView) findViewById(R.id.button3);


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


        btn_Abrir_Popup.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(MainActivity.this, AyudaActivity.class);
                startActivity(i);
            }
        });
    }


/*    public void feeling(View v) {

        if (btn3.isChecked()) {
            btn1.setButtonDrawable(R.mipmap.ic_happy_uncolor);
            btn2.setButtonDrawable(R.mipmap.ic_neutral_uncolor);
            btn3.setButtonDrawable(R.mipmap.ic_sad_color);
        } else if (btn2.isChecked()) {
            btn1.setButtonDrawable(R.mipmap.ic_happy_uncolor);
            btn2.setButtonDrawable(R.mipmap.ic_neutro_color);
            btn3.setButtonDrawable(R.mipmap.ic_sad_uncolor);
        } else if (btn1.isChecked()) {
            btn1.setButtonDrawable(R.mipmap.ic_happy_color);
            btn2.setButtonDrawable(R.mipmap.ic_neutral_uncolor);
            btn3.setButtonDrawable(R.mipmap.ic_sad_uncolor);
        } else {
            btn1.setButtonDrawable(R.mipmap.ic_happy_uncolor);
            btn2.setButtonDrawable(R.mipmap.ic_neutral_uncolor);
            btn3.setButtonDrawable(R.mipmap.ic_sad_uncolor);
        }
        btn1.setChecked(false);
        btn2.setChecked(false);
        btn3.setChecked(false);
    }*/
}

