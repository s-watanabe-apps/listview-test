package com.swapps.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> listItems = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            listItems.add("Test-" + i);
        }

        listView = findViewById(R.id.list_view);
        listAdapter = new ListAdapter(this, R.layout.list_item, listItems);
        listView.setAdapter(listAdapter);
    }
}