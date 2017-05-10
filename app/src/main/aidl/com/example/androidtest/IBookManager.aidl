// IBookManager.aidl
package com.example.androidtest;

// Declare any non-default types here with import statements
import com.example.androidtest.aidl.Book;
interface IBookManager {
            List<Book> getBooks();
            void addBook(in Book book);
}
