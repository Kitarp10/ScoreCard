package com.example.kiit.scorecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et1;
    Button btn;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        et1 = findViewById(R.id.editText7);
        btn = findViewById(R.id.button9);
        db = openOrCreateDatabase("pratik_db", MODE_PRIVATE, null);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // String id = et1.getText().toString();
        //String sql = "delete from student where id='" + id + "'";
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
       // builder.setIcon(R.drawable.image1);
        builder.setTitle("STUDENT DATABASE");
        builder.setMessage("Do you want to delete?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String RollNo = et1.getText().toString();
                String sql = "delete from student where RollNo='" + RollNo + "'";
                try {

                    db.execSQL(sql);
                    Toast.makeText(DeleteActivity.this, "Deleted", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(DeleteActivity.this, "Error" + e, Toast.LENGTH_LONG).show();
                }
            }
        });

        builder.setNeutralButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DeleteActivity.this, "NOT DELETED", Toast.LENGTH_LONG).show();
            }
        });
        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }
}

