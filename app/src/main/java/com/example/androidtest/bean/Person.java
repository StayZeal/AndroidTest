package com.example.androidtest.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * parcelabe 的使用
 */
public class Person implements Parcelable {

    private String id;
    private String name;
    private String sex;
    private int age;
    private String address;

    protected Person(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.sex = in.readString();
        this.age = in.readInt();
        this.address = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }
















    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(id);
        dest.writeString(sex);
        dest.writeInt(age);
        dest.writeString(address);
    }
}
