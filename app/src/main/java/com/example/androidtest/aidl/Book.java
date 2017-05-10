package com.example.androidtest.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yangfeng on 2017/2/13.
 */
public class Book implements Parcelable {

    private float price;
    private String id;
    private String name;

    public Book(float price, String id, String name) {
        this.price = price;
        this.id = id;
        this.name = name;
    }

    protected Book(Parcel in) {
        this.price = in.readFloat();
        this.id = in.readString();
        this.name = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(price);
        dest.writeString(id);
        dest.writeString(name);
    }
}
