package com.example.mobapp;

import com.example.mobapp.R;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class Mobile_App extends AppCompatActivity {

  TextView ftxt;
  EditText name_edit1;
  Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobile_app);
        ftxt = (TextView) findViewById(R.id.txtview);
        name_edit1=(EditText) findViewById(R.id.fname_edit);
        bt1=(Button) findViewById(R.id.bsave);

        bt1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String userinput= name_edit1.getText().toString();
                Toast.makeText(getApplicationContext(), "Hello"+userinput, Toast.LENGTH_LONG).show();
            }
        });
    }

}