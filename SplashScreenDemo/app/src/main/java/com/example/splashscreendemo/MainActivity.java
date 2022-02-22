package com.example.splashscreendemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText _phone_number;
    private Button _call_Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _phone_number = (EditText) findViewById((R.id.phone_number));

        _call_Button = (Button) findViewById((R.id.call_button));

        _call_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void  onClick (View V)
            {
                String CallingNumber = _phone_number.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(("tel:"+ CallingNumber)));
                startActivity(intent);
            }

        });
    }
}