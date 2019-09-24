package com.android.sqlitedatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;
    EditText etName,etSurname,etMarks,etId;
    Button btnAddData,btnShowData,btnUpdateData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper=new DatabaseHelper(this);
        etName=(EditText) findViewById(R.id.etName);
        etSurname=(EditText) findViewById(R.id.etSurname);
        etMarks=(EditText) findViewById(R.id.etMarks);
        etId=(EditText) findViewById(R.id.etId);
        btnAddData=(Button) findViewById(R.id.btnAddData);
        btnShowData=(Button) findViewById(R.id.btnShowData);
        btnUpdateData=(Button) findViewById(R.id.btnUpdateData);
        AddData();
        ShowData();
        UpdateData();
    }
    public void UpdateData(){
        btnUpdateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate=dbHelper.updateData(etId.getText().toString(),
                        etName.getText().toString(),etSurname.getText().toString(),
                        etMarks.getText().toString());
                if (isUpdate){
                    Toast.makeText(MainActivity.this,"Data Updated",Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(MainActivity.this,"Data isn't Updated",Toast.LENGTH_SHORT).show();
            }
        });
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

    public void ShowData(){
        btnShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=dbHelper.getData();
                if (res.getCount()==0){
                    showMessage("Error","No records are found");
                    return;
                }

                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("ID : "+res.getString(0)+"\n");
                    buffer.append("Name : "+res.getString(1)+"\n");
                    buffer.append("SurName : "+res.getString(2)+"\n");
                    buffer.append("Marks : "+res.getString(3)+"\n\n");
                }
                showMessage("Data",buffer.toString());
            }
        });
    }
    public void showMessage(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
