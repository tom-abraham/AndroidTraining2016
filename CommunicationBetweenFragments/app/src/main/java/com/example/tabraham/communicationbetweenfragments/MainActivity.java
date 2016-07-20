package com.example.tabraham.communicationbetweenfragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements Fragment1.CommunicationInterface{
    RelativeLayout mRelativeLayoutFragment1 ;
    RelativeLayout mRelativeLayoutFragment2;
    Fragment1 fragment1;
    Fragment2 fragment2;

    public int mTom;
    public static  final  String TAG_FRAGMENT_ONE = "FRAGMENT_ONE";
    public static  final  String TAG_FRAGMENT_TWO = "FRAGMENT_TWO";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRelativeLayoutFragment1 = (RelativeLayout) findViewById(R.id.fragment1);
        mRelativeLayoutFragment2 = (RelativeLayout) findViewById(R.id.fragment2);

        if (fragment1 == null)
        {
            FragmentManager fragmentManager =  getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragment1=Fragment1.getInstance();
            fragmentTransaction.add(R.id.fragment1,fragment1,TAG_FRAGMENT_ONE);
            fragmentTransaction.commit();
        }
        if (fragment2 == null)
        {
            FragmentManager fragmentManager =  getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragment2=Fragment2.getInstance();
            fragmentTransaction.add(R.id.fragment2,fragment2,TAG_FRAGMENT_ONE);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void passData(String mString) {
        fragment2.setData(mString);

    }
}
