package com.example.tabraham.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tabraham on 12/7/16.
 */


public class CustomBaseAdapter extends BaseAdapter {
    MainActivity mMainActivity;
    List<RawItem> mMmItems;



    public CustomBaseAdapter(MainActivity mainActivity, List<RawItem> mItems) {
        this.mMainActivity=mainActivity;
        this.mMmItems=mItems;
    }

    @Override
    public int getCount() {
        return mMmItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mMmItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView mImageView;
        TextView mTextView;
        TextView mTextViewDescription;

        LayoutInflater layoutInflator = (LayoutInflater) mMainActivity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=layoutInflator.inflate(R.layout.raw_item,null);

        mImageView = (ImageView) convertView.findViewById(R.id.imageView);
        mTextView = (TextView) convertView.findViewById(R.id.textViewTitle);
        mTextViewDescription = (TextView) convertView.findViewById(R.id.textViewDescription);
        RawItem item = (RawItem) getItem(position);
        mImageView.setImageResource(item.getmImageId());
        mTextView .setText(item.getmTitle());
        mTextViewDescription.setText(item.getmDescription());
        return convertView;
    }
}
