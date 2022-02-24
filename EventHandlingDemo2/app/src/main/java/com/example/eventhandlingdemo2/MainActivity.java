package com.example.eventhandlingdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout myLayout;
    Button btn1, btn2, btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLayout = (LinearLayout) findViewById(R.id.myLayout);
        btn1 = new Button(this);
        btn2 = new Button(this);
        btn3 = new Button(this);

        btn1.setText("Anonymous Method");
        myLayout.addView(btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Anonymous class approach", Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setText("Class Approch");
        myLayout.addView(btn2);
        btn2.setOnClickListener(new ApprochListner());
    }
    public  class  ApprochListner implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this,"Class approach", Toast.LENGTH_SHORT).show();
        }
    }
}

