package com.durgaprasad.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button allBooks,readingBooks,readBooks,wishList,favorites,about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        allBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AllBooksActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        allBooks = findViewById(R.id.allBooksBtn);
        readingBooks = findViewById(R.id.currentReadingBooksBtn);
        readBooks = findViewById(R.id.alreadyReadBooksBtn);
        wishList = findViewById(R.id.wishListBtn);
        favorites = findViewById(R.id.favoritesBtn);
        about = findViewById(R.id.aboutBtn);
    }
}