package com.example.java;

import java.util.ArrayList;
import java.util.List;

public class WordDocument implements Cloneable {

    private String mText;
    private ArrayList<String> mImages = new ArrayList<>();

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public void addImage(String image) {
        mImages.add(image);
    }

    public List<String> getmImages() {
        return mImages;
    }

    public void setmImages(ArrayList<String> mImages) {
        this.mImages = mImages;
    }


    @Override
    protected Object clone() {
        WordDocument doc = null;
        try {
            doc = (WordDocument) super.clone();
            doc.mText = this.mText;
            doc.mImages = (ArrayList<String>) this.mImages.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return doc;
    }

    public void showDocument() {
        System.out.println("---------------start-----" + toString() + "-------");
        System.out.println("mtext:" + this.mText);
        for (int i = 0; i < mImages.size(); i++) {
            System.out.println("mImages:" + mImages.get(i));
        }
        System.out.println("---------------end------------");


    }
}
