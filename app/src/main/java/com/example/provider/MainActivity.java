package com.example.provider;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_ASK_PERMISSION = 1001;
    private Button doctinnhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize the button with findViewById
        doctinnhan = findViewById(R.id.btn2);
        addEvent();
    }

    private void xulimomanhinhtinnhan() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_SMS}, REQUEST_CODE_ASK_PERMISSION);
        } else {
            Intent intent = new Intent(MainActivity.this, DocTinNhan.class);
            startActivity(intent);
        }
    }

    private void addEvent()
    {
        doctinnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulimomanhinhtinnhan();
            }
        });
    }





}




