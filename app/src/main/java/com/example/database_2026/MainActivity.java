package com.example.database_2026;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btsave,btview,btupdate,deletebutton;
    EditText name,phonenumber,contactid;
    TextView txtview;
    ArrayAdapter adapter;
    ListView listView;
    List<Contact> contacts ;
    List<String> myarraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(this);
        btsave=(Button)findViewById(R.id.save);
        btview=(Button)findViewById(R.id.view);
        btupdate=(Button)findViewById(R.id.update);
        deletebutton=(Button)findViewById(R.id.deletebutton);
        name=(EditText) findViewById(R.id.name);
        phonenumber=(EditText) findViewById(R.id.phonenumber);
        contactid=(EditText) findViewById(R.id.contactid);

        name.requestFocus();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        txtview=(TextView) findViewById(R.id.textv);

        listView = (ListView) findViewById(R.id.mobile_list);

        // Inserting Contacts
      /*  Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("aschalew", "0916021638"));
        db.addContact(new Contact("hiwot", "0916157392"));
        db.addContact(new Contact("sami", "0916023807"));*/
        btsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!name.getText().equals("") && !phonenumber.getText().equals(""))
                {
                    db.addContact(new Contact(name.getText().toString(), phonenumber.getText().toString()));
                    Toast.makeText(getApplicationContext(),"Insert successful",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please fill empty fields!",Toast.LENGTH_LONG).show();
                }
            }
        });
        btview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contacts = db.getAllContacts();
                myarraylist = new ArrayList<String>();
                for (Contact cn : contacts) {
                    myarraylist.add("Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
                            cn.getPhoneNumber());
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                        getApplicationContext(),
                        android.R.layout.simple_list_item_1,
                        myarraylist);
                listView.setAdapter(arrayAdapter);
            }
        });
        btupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate(name) || validate(phonenumber)|| validate(contactid))
                {
                    db.addContact(new Contact(name.getText().toString(), phonenumber.getText().toString()));
                    db.updatedata(contactid.getText().toString(),
                            name.getText().toString(),phonenumber.getText().toString());
                    Toast.makeText(getApplicationContext(),"Update successful",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please fill empty fields!",Toast.LENGTH_LONG).show();
                }
            }
        });
        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(contactid.getText().toString().trim().length() > 0)
                {
                    db.deletedata(contactid.getText().toString());
                    Toast.makeText(getApplicationContext(),"Delete successful",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please fill ID field!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    boolean validate(EditText text)
    {
        if(text.getText().toString().trim().length() > 0)
            return true;
        else
            return  false;
    }
}