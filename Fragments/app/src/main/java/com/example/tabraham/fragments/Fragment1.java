package com.example.tabraham.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tabraham on 18/7/16.
 */
public class Fragment1 extends Fragment{
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        System.out.println("TA-> Fragment onAttach:");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("TA-> Fragment onCreate:");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println("TA-> Fragment onCreateView:");
        View mView = inflater.inflate(R.layout.fragmet_layout,container);
        return mView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("TA-> Fragment onActivityCreated:");

    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("TA-> Fragment onStart:");

    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("TA-> Fragment onResume:");

    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("TA-> Fragment onPause:");

    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("TA-> Fragment onStop:");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("TA-> Fragment onDestroyView:");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("TA-> Fragment onDestroy:");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("TA-> Fragment onDetach:");

    }
}
