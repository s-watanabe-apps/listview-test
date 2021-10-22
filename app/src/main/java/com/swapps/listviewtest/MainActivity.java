package com.swapps.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    ListAdapter listAdapter;

    Boolean isLastLine = false;

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

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                //
            }

            @Override
            public void onScroll(AbsListView absListView,
                                 int firstVisibleItem,
                                 int visibleItemCount,
                                 int totalItemCount) {

                if (isLastLine) {
                    isLastLine = (totalItemCount == firstVisibleItem + visibleItemCount);
                } else {
                    isLastLine = (totalItemCount == firstVisibleItem + visibleItemCount);
                    if (isLastLine) {
                        Toast.makeText(MainActivity.this, "最終行", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}