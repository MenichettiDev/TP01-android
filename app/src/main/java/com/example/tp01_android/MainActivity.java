package com.example.tp01_android;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ModoAvionReceiver modoAvion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        modoAvion = new ModoAvionReceiver();
        // creo el filtro para escuchar el cambio de modo avión
        IntentFilter cambio = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        // registro el receiver con ese filtro
        registerReceiver(modoAvion, cambio);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Desregistro el receiver
        unregisterReceiver(modoAvion);
    }
}