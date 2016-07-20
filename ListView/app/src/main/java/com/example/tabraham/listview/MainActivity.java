package com.example.tabraham.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    String[] mTitle = new String[]{"Version1","Version2","Version3"};
    String[] mDescription = new String[]{"good","nice","great"};
    int[] mImages = new int[]{R.drawable.a1, R.drawable.a2, R.drawable.a3};

    List<RawItem> mItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);
        mItems = new ArrayList<>();

        for (int i = 0; i<mImages.length;i++)
        {
            RawItem item = new RawItem(mTitle[i],mDescription[i],mImages[i]);
            mItems.add(item);
        }
        CustomBaseAdapter mAdapter = new CustomBaseAdapter(this,mItems);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Item position is : "+position+"Item descrition  : "+((RawItem)parent.getItemAtPosition(position)).getmDescription(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
