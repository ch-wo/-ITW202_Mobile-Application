package com.example.todo_25;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    EditText editName,editSurname,editMarks,editTextId;
    Button addBtn, viewBtn, updateBtn, deleteBtn;

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
            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_SHORT).show();
    }

    public void ViewData(View view) {
        Cursor res = databaseHelper.getAllDate();
        if(res.getCount() == 0){
            showMessage("Error","Nothing to show");
        }
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            buffer.append("Student id : "+ res.getString(0)+"\n");
            buffer.append("First Name : "+ res.getString(1)+"\n");
            buffer.append("Last Name : "+ res.getString(2)+"\n");
            buffer.append("ITW202 marks : "+ res.getString(3)+"\n");

        }
        showMessage("Lists of students", buffer.toString());
    }
    public  void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void UpdateData(View view) {
        boolean isUpdated = databaseHelper.updateData(editTextId.getText().toString(),
                editName.getText().toString(),
                editSurname.getText().toString(),
                editMarks.getText().toString() );

        if(isUpdated == true)
            Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "Data not Updated", Toast.LENGTH_SHORT).show();
    }

    public void DeleteData(View view) {
        Integer deleteRows = databaseHelper.deleteData(editTextId.getText().toString());
        if(deleteRows>0){
            Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(MainActivity.this, "Data not Deleted", Toast.LENGTH_SHORT).show();
    }
}