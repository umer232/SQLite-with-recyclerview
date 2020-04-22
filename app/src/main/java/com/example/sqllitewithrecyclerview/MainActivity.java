package com.example.sqllitewithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edName , edNumber;
    Button btn;
    MyDatabse myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edName=findViewById(R.id.Username);
        edNumber=findViewById(R.id.ContactNumber);

        btn=findViewById(R.id.btn);

        myDB=new MyDatabse(MainActivity.this);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
            myDB.insertData(edName.getText().toString(),edNumber.getText().toString());
                Intent i=new Intent(MainActivity.this,DisplayActivity.class);
                startActivity(i);
            }
        });
    }
}
