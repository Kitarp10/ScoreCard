package com.example.kiit.scorecard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et1,et2;
    Button btn;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        et1=findViewById(R.id.editText);
        et2=findViewById(R.id.editText2);
        btn=findViewById(R.id.button6);
        db=openOrCreateDatabase("pratik_db",MODE_PRIVATE,null);
        btn.setOnClickListener(this);
    }

    public void onBackPressed(){
        super.onBackPressed();
        Intent intent = new Intent(this,maindatabase.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        String RollNo=et1.getText().toString();
        String Points=et2.getText().toString();
        String sql="update student set Points = '"+Points+"' where RollNo='"+RollNo+"'";
        try {

            db.execSQL(sql);
            Toast.makeText(this,"Data updated",Toast.LENGTH_LONG).show();


        }
        catch(Exception e)
        {
            Toast.makeText(this,"Failed",Toast.LENGTH_LONG).show();

        }


    }


}
