package com.durgaprasad.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BookActivity extends AppCompatActivity {
    ImageView bookImage;
    Button currentlyReading,wantToRead,alreadyRead,favorites;
    TextView bookName,author,pages,description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        init();
        Books book = new Books(1,"master python",250,"https://www.filepicker.io/api/file/BFMMlbcQvml9HSqXcvNp","Durga Prasad Mamidi","Learn Python with Fun","one stop to learn python");
        String desc = "Python was conceived in the late 1980s[35] by Guido van Rossum at Centrum Wiskunde & Informatica (CWI) in the Netherlands as a successor to the ABC language (itself inspired by SETL),[36] capable of exception handling and interfacing with the Amoeba operating system.[8] Its implementation began in December 1989.[37] Van Rossum shouldered sole responsibility for the project, as the lead developer, until 12 July 2018, when he announced his \"permanent vacation\" from his responsibilities as Python's Benevolent Dictator For Life, a title the Python community bestowed upon him to reflect his long-term commitment as the project's chief decision-maker.[38] He now shares his leadership as a member of a five-person steering council.[39][40][41] In January 2019, active Python core developers elected Brett Cannon, Nick Coghlan, Barry Warsaw, Carol Willing and Van Rossum to a five-member \"Steering Council\" to lead the project.[42]\n" +
                "\n" +
                "Python 2.0 was released on 16 October 2000 with many major new features, including a cycle-detecting garbage collector and support for Unicode.[43]\n" +
                "\n" +
                "Python 3.0 was released on 3 December 2008. It was a major revision of the language that is not completely backward-compatible.[44] Many of its major features were backported to Python 2.6.x[45] and 2.7.x version series. Releases of Python 3 include the 2to3 utility, which automates (at least partially) the translation of Python 2 code to Python 3.[46]";
        book.setLongDesc(desc);
        setData(book);
    }
    private void init(){
        bookImage = findViewById(R.id.imageView);
        currentlyReading = findViewById(R.id.btnCurrentlyReading);
        wantToRead = findViewById(R.id.btnWantToRead);
        alreadyRead = findViewById(R.id.btnAlreadyRead);
        favorites = findViewById(R.id.btnFavorites);
        bookName = findViewById(R.id.txtBookName);
        author = findViewById(R.id.txtAuthorName);
        pages = findViewById(R.id.txtPagesCount);
        description = findViewById(R.id.txtDescriptionMatter);
    }
    private void setData(Books book) {
        Glide.with(this)
                .asBitmap()
                .load(book.getUrl())
                .into(bookImage);
        bookName.setText(book.getName());
        author.setText(book.getAuthor());
        pages.setText(String.valueOf(book.getPages()));
        description.setText(book.getLongDesc());
    }
}