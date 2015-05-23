package com.app1.neil.ca2emoji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.parse.ParseObject;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onGetNameClick(View view) {
        Intent getNameScreenIntent = new Intent(MainActivity.this, SecondActivity.class);
        final int result =1;

        getNameScreenIntent.putExtra("callingActivity", "MainActivity");

        startActivityForResult(getNameScreenIntent, result);

    }

    public void onViewInboxClick(View view) {
        Intent getInboxScreenIntent = new Intent(MainActivity.this, ThirdActivityInbox.class);

        getInboxScreenIntent.putExtra("callingActivity", "MainActivity");

        startActivity(getInboxScreenIntent);

    }

    public void onViewRecorderClick(View view) {
        Intent getRecorderScreenIntent = new Intent(MainActivity.this, Recorder.class);

        getRecorderScreenIntent.putExtra("callingActivity", "MainActivity");

        startActivity(getRecorderScreenIntent);

    }
    public void onViewContactListClick(View view) {
        Intent getContactList = new Intent(MainActivity.this, AddContactActivity.class);

        getContactList.putExtra("callingActivity", "MainActivity");

        startActivity(getContactList);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView usersNameMessage = (TextView)
            findViewById(R.id.users_name_message);
        String nameSentBack  = data.getStringExtra("UsersName");
        usersNameMessage.append(" " + nameSentBack);
    }
}
