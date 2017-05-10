package com.example.androidtest.aidl;

import android.os.IBinder;
import android.os.RemoteException;

import com.example.androidtest.IBookManager;

import java.util.List;

 
public class BookManagerImpl implements IBookManager {

    @Override
    public List<Book> getBooks() throws RemoteException {
        return null;
    }

    @Override
    public void addBook(Book book) throws RemoteException {

    }

    @Override
    public IBinder asBinder() {
        return null;
    }
}
