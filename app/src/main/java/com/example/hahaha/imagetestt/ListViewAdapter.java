package com.example.hahaha.imagetestt;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hahaha on 9/6/16.
 */
public class ListViewAdapter extends ArrayAdapter<Integer> {
    private int id;

    public ListViewAdapter(Context context, int resource, List<Integer> objects) {
        super(context, resource, objects);
        id=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Integer a=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(id,null);
        TextView textView= (TextView) view.findViewById(R.id.listview_tv);
        textView.setText(a.toString());
        return view;
    }
}
