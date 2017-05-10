package com.example.androidtest.activity;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;

import com.example.androidtest.IBookManager;
import com.example.androidtest.R;
import com.example.androidtest.aidl.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AidlServerActivity extends AppCompatActivity {


    private List<Book> books = new ArrayList<>();

    private Map map = new HashMap( );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);
    }


    private final IBookManager.Stub mBookManger = new IBookManager.Stub() {
        @Override
        public List<Book> getBooks() throws RemoteException {
            return books;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            books.add(book);
        }
    };
}
