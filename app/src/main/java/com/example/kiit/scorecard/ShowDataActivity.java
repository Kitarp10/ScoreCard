package com.example.kiit.scorecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ShowDataActivity extends AppCompatActivity {
    TableLayout tableLayout;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        tableLayout=findViewById(R.id.tablelayout);
        SQLiteDatabase db=openOrCreateDatabase("pratik_db",MODE_PRIVATE,null);
        String sql="select* from student";
        Cursor c=db.rawQuery(sql,null);
        while(c.moveToNext())
        {
            String RollNo=c.getString(0);
            String Name=c.getString(1);
            String  Mob=c.getString(2);
            String  Points=c.getString(3);
            TableRow tr=new TableRow(this);
            TextView tv1=new TextView(this);
            TextView tv2=new TextView(this);
            TextView tv3=new TextView(this);
            TextView tv4=new TextView(this);
            tv1.setText(RollNo.concat("         "));
            tv2.setText(Name.concat("            "));
            tv3.setText(Mob.concat("                   "));
            tv4.setText(Points.concat("                  "));
            tr.addView(tv1);
            tr.addView(tv2);
            tr.addView(tv3);
            tr.addView(tv4);
            if(i%2==0)
                tr.setBackgroundColor(Color.YELLOW);
            else
                tr.setBackgroundColor(Color.MAGENTA);

            tableLayout.addView(tr);
            i++;
        }
    }
}

