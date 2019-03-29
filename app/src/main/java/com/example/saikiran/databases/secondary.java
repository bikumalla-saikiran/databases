package com.example.saikiran.databases;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class secondary extends AppCompatActivity {

    EditText e1;
    TextView t1,t2,t3;
    SQLiteDatabase sdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        e1=findViewById(R.id.editText4);
        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.textView2);
        t3=findViewById(R.id.textView3);
        sdb =openOrCreateDatabase("SREE",MODE_PRIVATE,null);
    }
    public void Buttonclick(View v)
    {
        String s= e1.getText().toString();
        Cursor c= sdb.rawQuery("select * from CSE where Rollno ='"+s+"'",null);
        if(c!=null)
        {
            c.moveToFirst();
            do {
                int a=c.getColumnIndex("Rollno");
                int b=c.getColumnIndex("name");
                int d=c.getColumnIndex("phone");
                String a1= c.getString(a);
                String a2= c.getString(b);
                String a3= c.getString(d);
                t1.setText(a1);
                t2.setText(a2);
                t3.setText(a3);
            }
            while(c.moveToNext());
        }
    }

}
