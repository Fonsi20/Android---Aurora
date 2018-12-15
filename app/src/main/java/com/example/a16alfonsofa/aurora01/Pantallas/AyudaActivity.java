package com.example.a16alfonsofa.aurora01.Pantallas;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a16alfonsofa.aurora01.R;

public class AyudaActivity extends AppCompatActivity {

    private static final int LLAMADA_TELEFONO = 1;
    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        btn1 = (Button) findViewById(R.id.btnEspeTlf);
        btn2 = (Button) findViewById(R.id.btn911);
    }

    public void llamarTlfEspe(View v) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)900110011"));
                startActivity(i);
            } else {
                requestPermissions(new String[]{android.Manifest.permission.CALL_PHONE}, LLAMADA_TELEFONO);
            }
        } else {
            Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)914590055"));
            startActivity(i);
        }

    }

    public void llamarTlf911(View v) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)112"));
                startActivity(i);
            } else {
                requestPermissions(new String[]{android.Manifest.permission.CALL_PHONE}, LLAMADA_TELEFONO);
            }
        } else {
            Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)986110011"));
            startActivity(i);
        }

    }
}
