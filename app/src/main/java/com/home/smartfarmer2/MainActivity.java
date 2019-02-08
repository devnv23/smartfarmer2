package com.home.smartfarmer2;

import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.view.View;
import android.content.Context;

public class MainActivity extends AppCompatActivity {
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button onSMS,offSMS,btnsetting,btnstatus,btnreset;
        onSMS=(Button) findViewById(R.id.btnonSMS);
        offSMS = (Button)findViewById(R.id.btnoffSMS);
        btnsetting= (Button)findViewById(R.id.btnsetting);
        btnstatus = (Button)findViewById(R.id.btnstatus);
        btnreset = (Button)findViewById(R.id.btnreset);
        final Vibrator vibe = (Vibrator) MainActivity.this.getSystemService(Context.VIBRATOR_SERVICE);
        onSMS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                vibe.vibrate(80);
                sendSMS("+918978796955", "*5678ON#");
            }
        });
        offSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(80);
                sendSMS("+918978796955", "*5678OFF#");
            }
        });
        btnsetting.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                vibe.vibrate(80);
                Intent intent = new Intent(context, Settings.class);
                startActivity(intent);
            }
        });
        btnstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(80);
                sendSMS("+918978796955", "*5678RTS#");
            }
        });
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(80);
                sendSMS("+918978796955", "*5678RST#");
            }
        });
    }
    private void sendSMS(String phoneNumber, String message)
    {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }
}
