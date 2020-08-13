package com.durgaprasad.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BookRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);
        adapter = new BookRecyclerAdapter(this);
        recyclerView = findViewById(R.id.allBooksRecyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Books> books = new ArrayList<>();
        books.add(new Books(1,"master python",250,"https://www.filepicker.io/api/file/BFMMlbcQvml9HSqXcvNp","Durga Prasad Mamidi","Learn Python with Fun","one stop to learn python"));
        books.add(new Books(1,"master python",250,"https://www.filepicker.io/api/file/BFMMlbcQvml9HSqXcvNp","Durga Prasad Mamidi","Learn Python with Fun","one stop to learn python"));
        books.add(new Books(1,"master python",250,"https://www.filepicker.io/api/file/BFMMlbcQvml9HSqXcvNp","Durga Prasad Mamidi","Learn Python with Fun","one stop to learn python"));
        books.add(new Books(1,"master python",250,"https://www.filepicker.io/api/file/BFMMlbcQvml9HSqXcvNp","Durga Prasad Mamidi","Learn Python with Fun","one stop to learn python"));
        books.add(new Books(1,"master python",250,"https://www.filepicker.io/api/file/BFMMlbcQvml9HSqXcvNp","Durga Prasad Mamidi","Learn Python with Fun","one stop to learn python"));

        adapter.setBooks(books);
    }
}