package com.example.tabraham.communicationbetweenfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by tabraham on 18/7/16.
 */
public class Fragment2 extends Fragment {
    TextView mTextView ;
    String mString;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_two,container,false);
        mTextView = (TextView) mView.findViewById(R.id.textViewData);
        return mView;
    }
    public static Fragment2 getInstance()
    {
        Fragment2 mFragment2 = new Fragment2();
        return mFragment2;
    }
    public void setData(String mString) {
        mTextView.setText(mString);
    }

}
