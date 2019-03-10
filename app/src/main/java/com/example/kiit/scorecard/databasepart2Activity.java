package com.example.kiit.scorecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class databasepart2Activity extends AppCompatActivity implements View.OnClickListener {
    EditText et1,et2,et3,et4;
    Button btn,btn2;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_databasepart2);

        et1=findViewById(R.id.editText3);
        et2=findViewById(R.id.editText4);
        et3=findViewById(R.id.editText5);
        et4=findViewById(R.id.editText6);
        btn=findViewById(R.id.button7);
        btn.setOnClickListener(this);
        btn2=findViewById(R.id.button8);
        btn2.setOnClickListener(this);
        db=openOrCreateDatabase("pratik_db",MODE_PRIVATE,null);
    }

    @Override
    public void onClick(View view) {
        if(view==btn) {
            String RollNo = et1.getText().toString();
            String Name = et2.getText().toString();
            String Mob = et3.getText().toString();
            String Points = et4.getText().toString();
            String sql = "insert into student values('" + RollNo + "','" + Name + "','" + Mob + "','" + Points + "')";
            try {
                db.execSQL(sql);
                Toast.makeText(this, "DATA INSERTED", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(this, "Error " + e, Toast.LENGTH_LONG).show();
            }
        }
        else{
            et1.setText("");
            et2.setText("");
            et3.setText("");
            et4.setText("");
        }

    }
}













