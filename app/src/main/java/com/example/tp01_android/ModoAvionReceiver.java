package com.example.tp01_android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class ModoAvionReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
            boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);

            if (isAirplaneModeOn) {
                Toast.makeText(context, "Llamando al Profe...", Toast.LENGTH_SHORT).show();
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:2664553747"));
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(callIntent);
            }else{
                Toast.makeText(context, "Cancelando llamada", Toast.LENGTH_SHORT).show();
            }
        }
    }
}