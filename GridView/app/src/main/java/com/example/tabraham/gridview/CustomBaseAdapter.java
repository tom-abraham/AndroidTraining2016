package com.example.tabraham.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tabraham on 11/7/16.
 */
public class CustomBaseAdapter extends BaseAdapter {
    String[] mTitles = new String[]{"cupCake","Donut", "Eclair" , "Froyo"};
    int[] mImages = new int[]{R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4};
    Context mContext;

    public CustomBaseAdapter(Context applicationContext) {
        mContext = applicationContext;
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = mInflater.inflate(R.layout.row_item,null);
        ImageView mImageView;
        TextView mTextView;
        mImageView = (ImageView) convertView.findViewById(R.id.imageViewData);
        mTextView = (TextView) convertView.findViewById(R.id.textViewData);
        mImageView.setImageResource(mImages[position]);
        mTextView.setText(mTitles[position]);
        return convertView;
    }
}
