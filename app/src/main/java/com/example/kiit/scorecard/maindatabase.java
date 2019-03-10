package com.example.kiit.scorecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class maindatabase extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maindatabase);
        db = openOrCreateDatabase("pratik_db", MODE_PRIVATE, null);
    }

    public void createTable(View view) {
        String sql = "create table if not exists student(RollNo Integer primary key,Name text,Mobile text,Points Integer)";
        try {
            db.execSQL(sql);
            Toast.makeText(this, "Table Created Successfully", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "ERROR" + e, Toast.LENGTH_LONG).show();
        }
    }
    public void updateData(View view) {
        Intent i=new Intent(this,password.class);
        startActivity(i);
    }

    public void insertData(View view){
        Intent i=new Intent(this,databasepart2Activity.class);
        startActivity(i);
    }

    public void deleteData(View view) {
        Intent i=new Intent(this,DeleteActivity.class);
        startActivity(i);

    }

    public void showData(View view) {
        Intent i=new Intent(this,ShowDataActivity.class);
        startActivity(i);

    }
}

