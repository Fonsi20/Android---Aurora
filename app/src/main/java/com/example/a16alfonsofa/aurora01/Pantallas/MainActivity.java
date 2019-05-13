package com.example.a16alfonsofa.aurora01.Pantallas;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.a16alfonsofa.aurora01.BBDD.BDHelper;
import com.example.a16alfonsofa.aurora01.R;
import com.example.a16alfonsofa.aurora01.TutorialActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    private ImageView btn1, btn2, btn3, btn_Abrir_Popup, btnprofile;
    private CardView btn4;

    private String BDname;
    private int BDversion;
    private SQLiteDatabase DBpsidb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        try {
            deployDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BDname = "psidb";
        BDversion = 1;
        BDHelper bdhelper = new BDHelper(this, BDname, null, BDversion);
        DBpsidb = bdhelper.getWritableDatabase();

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

    private void deployDatabase() throws IOException {


        //Open your local db as the input stream
        String packageName = getApplicationContext().getPackageName();
        String DB_PATH = "/data/data/" + packageName + "/databases/";
        //Create the directory if it does not exist
        File directory = new File(DB_PATH);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String DB_NAME = "psidb"; //The name of the source sqlite file

        InputStream myInput = getAssets().open("psidb");

        // Path to the just created empty db
        String outFileName = DB_PATH + DB_NAME;

        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    @Override
    protected void onResume() {
        super.onResume();
        String tutorialKey = "SOME_KEY";
        Boolean firstTime = getPreferences(MODE_PRIVATE).getBoolean(tutorialKey, true);
        if (firstTime) {
            runTutorial(); // here you do what you want to do - an activity tutorial in my case
            getPreferences(MODE_PRIVATE).edit().putBoolean(tutorialKey, false).apply();
        }
    }

    private void runTutorial() {
        Intent i = new Intent(MainActivity.this, TutorialActivity.class);
        startActivity(i);
    }
}

