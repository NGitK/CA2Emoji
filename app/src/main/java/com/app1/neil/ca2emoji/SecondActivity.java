package com.app1.neil.ca2emoji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent activityThatCalled = getIntent();

        String previousActivity = activityThatCalled.getExtras().getString("callingActivity", "MainActivity");

        TextView callingActivityMessage =(TextView)
                findViewById(R.id.calling_activity_info_text_view);
        callingActivityMessage.append(" " + previousActivity);
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
        EditText userNameET = (EditText)
                findViewById(R.id.users_name_edit_text);
        String userName =String.valueOf(userNameET.getText());

               Intent goingBack = new Intent();

        goingBack.putExtra("UsersName", userName);

        setResult(RESULT_OK, goingBack);

        finish();


    }
}
