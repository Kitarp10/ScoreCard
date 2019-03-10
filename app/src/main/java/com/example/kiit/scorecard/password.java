package com.example.kiit.scorecard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class password extends AppCompatActivity implements View.OnClickListener {
    EditText e1,e2;
    Button b1,b2;
    String x,y,z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        e1=findViewById(R.id.editText10);
        e2=findViewById(R.id.editText9);
        b1=findViewById(R.id.button10);
        b1.setOnClickListener(this);
        b2=findViewById(R.id.button11);
        b2.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        String id=String.valueOf(e1.getText());
        String pass=String.valueOf(e2.getText());
        String p = "hahaha";
        String num= "99";
        if(view==b1)
        {
            if((id.equals(num))&&(pass.equals(p)))
            {
                Intent i = new Intent(this, UpdateActivity.class);
                startActivity(i);

            }
            else
                {
                    Toast.makeText(this, "Invalid Input" , Toast.LENGTH_LONG).show();
                }
        }
        else
            {
                e1.setText("");
                e2.setText("");
            }
    }
}
