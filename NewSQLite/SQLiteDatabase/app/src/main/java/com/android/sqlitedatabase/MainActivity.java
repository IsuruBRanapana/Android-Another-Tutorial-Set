package com.android.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;
    EditText etName,etSurname,etMarks;
    Button btnAddData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper=new DatabaseHelper(this);
        etName=(EditText) findViewById(R.id.etName);
        etSurname=(EditText) findViewById(R.id.etSurname);
        etMarks=(EditText) findViewById(R.id.etMarks);
        btnAddData=(Button) findViewById(R.id.btnAddData);
        AddData();
    }
    public void AddData(){
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInsert=dbHelper.insertData(etName.getText().toString(),etSurname.getText().toString(),Integer.parseInt(etMarks.getText().toString()));
                if (isInsert){
                    Toast.makeText(MainActivity.this,"Data Inserted", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(MainActivity.this,"Data isn't Inserted",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
