package com.app1.neil.ca2emoji;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMSActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms_activity);

        final EditText phoneNumber = (EditText) findViewById(R.id.editTextPhone);
        final EditText textArea = (EditText) findViewById(R.id.editTextMessage);
        Button messageButton = (Button) findViewById(R.id.button1);

        Intent i = getIntent();
        String ph = i.getStringExtra("ContactNumber");
        EditText phoneET = (EditText)
                findViewById(R.id.editTextPhone);
        //phoneET.append(" " + phoneNumberBack);
        phoneET.setText(ph);

        messageButton.setOnClickListener(new OnClickListener () {
            public void onClick(View v) {
                String stringPhone = "" + phoneNumber.getText();
                String sms = "" + textArea.getText();
                if ("".equals(stringPhone) || "".equals(sms)) {
                    Toast.makeText(SMSActivity.this, "Phone number or message text cannot be blank", Toast.LENGTH_LONG).show();
                } else {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(stringPhone, null, sms, null, null);
                    Toast.makeText(SMSActivity.this, "Message sent", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        EditText phoneET = (EditText)
                findViewById(R.id.editTextPhone);
        String phoneNumberBack  = data.getStringExtra("ContactNumber");
        //phoneET.append(" " + phoneNumberBack);
        phoneET.setText(phoneNumberBack);
    }*/
}