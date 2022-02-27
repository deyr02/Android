package com.example.booklabraryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText title_input, author_input, pages_input;
    Button save_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        title_input = (EditText) findViewById(R.id.titl_input);
        author_input = (EditText) findViewById(R.id.author_input);
        pages_input = (EditText) findViewById(R.id.pages_input);

        save_button = (Button) findViewById(R.id.save_button);

        save_button.setOnClickListener(view -> {
            MyDatabaseHelper mydbh = new MyDatabaseHelper(AddActivity.this);
            mydbh.AddBook(title_input.getText().toString().trim(),
                        author_input.getText().toString().trim(),
                        Integer.parseInt(pages_input.getText().toString().trim())
                    );
        });

    }
}