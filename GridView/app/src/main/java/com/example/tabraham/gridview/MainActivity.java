package com.example.tabraham.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView mGridView;
    ListView mListView;
    CustomBaseAdapter mCustomBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGridView = (GridView)findViewById(R.id.gridView);
        mListView = (ListView) findViewById(R.id.listView);
        mCustomBaseAdapter = new CustomBaseAdapter(getApplicationContext());
        mGridView.setAdapter(mCustomBaseAdapter);
        mListView.setAdapter(mCustomBaseAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Position : "+position, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "id : "+mGridView.getSelectedItem(), Toast.LENGTH_SHORT).show();

            }
        });
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Position : "+position, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "id : "+mListView.getSelectedItem(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
