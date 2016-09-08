package com.example.hahaha.imagetestt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Activity_ListView extends AppCompatActivity {

    private ListView listView;
    private ListViewAdapter listViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ArrayList<Integer> arrayList=new ArrayList<>();
        for(int i=0;i<30;++i){
            arrayList.add(i);
        }
        listViewAdapter=new ListViewAdapter(Activity_ListView.this,R.layout.layout_item,arrayList);

        listView= (ListView) findViewById(R.id.listview);
        listView.setAdapter(listViewAdapter);
    }
}
