package com.example.sqllitewithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {

    RecyclerView rv;
    String id, name , number;
    ArrayList<GetterSetter> al=new ArrayList<>();
    MyDatabse myDB;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        rv=findViewById(R.id.rev);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(DisplayActivity.this);
                rv.setLayoutManager(layoutManager);

                myDB= new MyDatabse(DisplayActivity.this);
                c= myDB.getData();
                if(c.getCount()>0)
                {
                    if (c.moveToFirst())
                    {
                        do {

                            id=c.getString(0);
                            name= c.getString(1);
                            number=c.getString(2);

                            GetterSetter gl= new GetterSetter(id,name,number);
                            al.add(gl);


                        }while (c.moveToNext());
                    }
                }

                MyAdapter my=new MyAdapter(DisplayActivity.this,al);
                rv.setAdapter(my);

    }
}
