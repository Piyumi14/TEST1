package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.DBHelper;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    Button btnAdd, btnView;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBHelper(this);

        et1 = findViewById(R.id.uname);
        btnAdd = findViewById(R.id.btnAdd);
        btnView = findViewById(R.id.btnView);
    }

    public void addDataa(View view) {
        String uname;
        uname = et1.getText().toString();

        boolean ans = db.add(uname);

        if (ans == true) {
            Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
        }
    }

    public  void viewData(View view){
        Intent i = new Intent(this,Next.class);
        startActivity(i);
    }
}