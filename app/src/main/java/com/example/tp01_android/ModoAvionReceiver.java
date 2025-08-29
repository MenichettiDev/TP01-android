package com.example.tp01_android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class ModoAvionReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

            boolean modeOn = intent.getBooleanExtra("state", false);

            if (modeOn) {
                Toast.makeText(context, "Llamando al Profe...", Toast.LENGTH_SHORT).show();
                Intent llamada = new Intent(Intent.ACTION_DIAL);
                llamada.setData(Uri.parse("tel:2664553747"));
                llamada.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(llamada);
            }else{
                Toast.makeText(context, "Cancelando llamada", Toast.LENGTH_SHORT).show();
            }

    }
}