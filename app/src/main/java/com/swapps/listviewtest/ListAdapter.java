package com.swapps.listviewtest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends ArrayAdapter<String> {
    private int resource;
    private List<String> items;
    private LayoutInflater inflater;
    private List<Boolean> itemsChecked;
    public ListAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
        this.resource = resource;
        this.items = items;
        itemsChecked = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            itemsChecked.add(false);
        }
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView != null) {
            view = convertView;
        } else {
            view = inflater.inflate(resource, null);
        }

        TextView itemName = view.findViewById(R.id.item_name);
        itemName.setText(items.get(position));

        CheckBox itemCheck = view.findViewById(R.id.item_check);
        itemCheck.setChecked(itemsChecked.get(position));
        itemCheck.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!itemsChecked.get(position)) {
                    itemsChecked.set(position, true);
                    itemCheck.setChecked(true);
                } else {
                    itemsChecked.set(position, false);
                    itemCheck.setChecked(false);
                }
            }
        });

        return view;
    }
}
