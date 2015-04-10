package com.app1.neil.ca2emoji;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class SecondActivity extends Activity {

    MediaPlayer mPlayer;
    Button buttonPlay, buttonStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mPlayer = MediaPlayer.create(this, R.raw.ringtone2);
        buttonPlay = (Button) findViewById(R.id.play_song_mp3_button);
        buttonStop = (Button) findViewById(R.id.pause_song_mp3_button);

        buttonPlay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                if (view == buttonPlay) {
                    mPlayer.start();
                } else {
                }
            }
        });

        buttonStop.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                if (view == buttonStop) {
                    mPlayer.stop();
                } else {
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


    public void onSendUsersName(View view) {
        TextView contactPhoneTextView = (TextView)
                findViewById(R.id.users_name_edit_text);
        String username =String.valueOf(contactPhoneTextView.getText());

               Intent returnName = new Intent();

        returnName.putExtra("Username", username);

        setResult(RESULT_OK, returnName);

        finish();


    }
}
