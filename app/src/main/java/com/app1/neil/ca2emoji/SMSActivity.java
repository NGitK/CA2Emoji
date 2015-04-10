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

        final EditText phone = (EditText) findViewById(R.id.editTextPhone);
        final EditText text = (EditText) findViewById(R.id.editTextMessage);
        final EditText emailAddress = (EditText) findViewById(R.id.editTextEmail);
        Button call = (Button) findViewById(R.id.button1);
        Button message = (Button) findViewById(R.id.button2);
        Button email = (Button) findViewById(R.id.button3);

        call.setOnClickListener(new OnClickListener () {
            public void onClick(View v) {
                String sPhone = "" + phone.getText();
                if ("".equals(sPhone)) {
                    Toast.makeText(SMSActivity.this, "Phone number cannot be blank", Toast.LENGTH_LONG).show();
                } else {
                    String sCall = "tel:" + sPhone;
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse(sCall));
                    startActivity(callIntent);
                }
            }
        });
        email.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String sEmail = "" + emailAddress.getText();
                if ("".equals(sEmail)) {
                    Toast.makeText(SMSActivity.this, "Email address cannot be blank", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    Uri data = Uri.parse("mailto:" + sEmail);
                    intent.setData(data);
                    startActivity(intent);
                }
            }
        });
        message.setOnClickListener(new OnClickListener () {
            public void onClick(View v) {
                String sPhone = "" + phone.getText();
                String sms = "" + text.getText();
                if ("".equals(sPhone) || "".equals(sms)) {
                    Toast.makeText(SMSActivity.this, "Phone number or message text cannot be blank", Toast.LENGTH_LONG).show();
                } else {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(sPhone, null, sms, null, null);
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        EditText contactNumberET = (EditText)
                findViewById(R.id.editTextPhone);
        String phoneNumberBack  = data.getStringExtra("ContactNumber");
        contactNumberET.append(" " + phoneNumberBack);
    }
}