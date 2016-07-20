package com.example.tabraham.communicationbetweenfragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by tabraham on 18/7/16.
 */
public class Fragment1 extends Fragment{
    EditText mEditText;
    Button mButton;
    String mString;
    CommunicationInterface listener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_one,container,false);
        mEditText= (EditText) mView.findViewById(R.id.editText);
        mButton= (Button) mView.findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mString= mEditText.getText().toString();
                listener.passData(mString);
            }
        });


        return mView;
    }

    public static Fragment1 getInstance()
    {
        Fragment1 mFragment1 = new Fragment1();
        return mFragment1;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CommunicationInterface)
        {
            listener = (CommunicationInterface)context;
        }
    }

    interface CommunicationInterface
    {
        void passData(String mString);

    }
}
