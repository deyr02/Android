package com.example.eventhandlingdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout layout;
    Button btnOk;
    Button Cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        layout = (LinearLayout) findViewById(R.id.myLayout_1);
        btnOk = new Button(this);
        Cancel = new Button(this);
        btnOk.setText("Ok");
        Cancel.setText("Cancel");
        layout.addView(btnOk);
        layout.addView(Cancel);

        btnOk.setOnClickListener(this);
        Cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Button btn = (Button) view;
        if(btn == btnOk){
            Toast.makeText(this, "Ok is clicketed", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Cancel is clicketed", Toast.LENGTH_SHORT).show();

        }

    }
}