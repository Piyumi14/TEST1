package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import Database.Adapter;
import Database.DBHelper;
import Database.Usermaster;

public class Next extends AppCompatActivity {


    DBHelper db;
    Adapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        RecyclerView recyclerView = findViewById(R.id.recycle);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = new DBHelper(this);

        madapter =  new Adapter(this,getAllItems());

        recyclerView.setAdapter(madapter);

        madapter.swapCursor(getAllItems());
    }

    public Cursor getAllItems(){
        return db.query();
    }
}
