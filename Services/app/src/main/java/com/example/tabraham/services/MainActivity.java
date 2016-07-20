package com.example.tabraham.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mStartButton;
    Button mStopButton;
    Intent i;
    Intent i1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStartButton =(Button) findViewById(R.id.buttonStart);
        mStopButton =(Button) findViewById(R.id.buttonStop);
        i= new Intent(this,MyService.class);
        i1=new Intent(this,MyIntentService.class);
        Toast.makeText(getApplicationContext(),"Inited", Toast.LENGTH_LONG).show();

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"clicked start service", Toast.LENGTH_LONG).show();
                startService(i);

            }
        });
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"clicked stop service", Toast.LENGTH_LONG).show();
                startService(i1);

//                stopService(i);


            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Toast.makeText(getApplicationContext(),"clicked stop service", Toast.LENGTH_LONG).show();

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        System.out.println("TA-> MainActivity onCreateOptionsMenu");

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        System.out.println("TA-> MainActivity onPrepareOptionsMenu");

        return super.onPrepareOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        System.out.println("TA-> MainActivity onOptionsItemSelected");

        switch (item.getItemId())
        {
            case R.id.item1:
                System.out.println("TA-> Item1 selected");
                break;
            case R.id.item2:
                System.out.println("TA-> Item2 selected");
                break;
            case R.id.item3:
                System.out.println("TA-> Item3 selected");
                break;
        }


        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
        System.out.println("TA-> MainActivity onOptionsMenuClosed");

    }
}
