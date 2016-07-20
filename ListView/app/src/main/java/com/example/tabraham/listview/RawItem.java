package com.example.tabraham.listview;

/**
 * Created by tabraham on 12/7/16.
 */
public class RawItem {
    public RawItem(String Title, String Descrition, int mImage) {
         mTitle = Title;
         mDescription = Descrition;
         mImageId =mImage;
    }



    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public void setmImageId(int mImageId) {
        this.mImageId = mImageId;
    }

    public String getmTitle() {

        return mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public int getmImageId() {
        return mImageId;
    }

    String mTitle;
    String mDescription;
    int mImageId;
}
