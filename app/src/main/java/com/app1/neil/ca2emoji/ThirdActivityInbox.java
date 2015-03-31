package com.app1.neil.ca2emoji;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ThirdActivityInbox extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity_inbox);


        String[] inboxMessages = {"See if you can guess the answer", "What time will you be ready at?",
                "You'll never guess what happened", "Are you sure that's the right answer?"};

        ListAdapter inboxAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                inboxMessages);

        ListView inboxListView = (ListView) findViewById(R.id.inboxListView);

        inboxListView.setAdapter(inboxAdapter);

        inboxListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                String messageClicked = "You Selected: " +
                        String.valueOf(adapterView.getItemAtPosition(position));
                Toast.makeText(ThirdActivityInbox.this, messageClicked, Toast.LENGTH_SHORT).show();
            }
        });


    }


}
