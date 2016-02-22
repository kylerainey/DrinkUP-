package com.example.kyle.drinkup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_DATA = "C:\\Users\\Kyle\\AndroidStudioProjects\\DrinkUp\\ABOUTDATA";
    static final private String TAG = "DrinkUP";
    ListView listViewMain;
    String[] listValue = new String[]{
            "BEERS",
            "MIXED DRINKS",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Starting onCreate...");

        listViewMain = (ListView) this.findViewById(R.id.listViewMain);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, android.R.id.text1, listValue);
        listViewMain.setAdapter(adapter);
        listViewMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(view.getContext(), Beers.class));
                        break;

                    case 1:
                        startActivity(new Intent(view.getContext(), MixedDrinks.class));
                        break;
                }
            }
            }

            );
        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.about:
                Intent intent = new Intent(this, AboutActivity.class);
                intent.putExtra(EXTRA_DATA, "About");
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    }


