package com.example.todo_25;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    EditText editName,editSurname,editMarks,editTextId;
    Button btnAddBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        editName = findViewById(R.id.fname);
        editSurname = findViewById(R.id.lname);
        editMarks = findViewById(R.id.marks);
        editTextId = findViewById(R.id.IDnumber);
    }

    public void AddData(View view) {
        boolean isInserted = databaseHelper.insertData(editTextId.getText().toString(),
                editName.getText().toString(),
                editSurname.getText().toString(),
                editMarks.getText().toString() );

        if(isInserted == true)
            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
    }
}