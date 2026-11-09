package com.example.mobapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView ftxt;
    EditText name_edit1;
    Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       ftxt = (TextView) findViewById(R.id.txtview);
       name_edit1 = (EditText) findViewById(R.id.fname_edit);
       bt1 = (Button) findViewById(R.id.bsave);

       bt1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String userinput = name_edit1.getText().toString();
               Toast.makeText(getApplicationContext(), "Hello"+userinput, Toast.LENGTH_LONG).show();
           }
       });
    }
}