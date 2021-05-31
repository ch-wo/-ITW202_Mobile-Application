package edu.gcit.todo_10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextValue1;
    private EditText editTextValue2;
    private TextView editTextResult;
    private Calculator mCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextValue1 = findViewById(R.id.editText1);
        editTextValue2 = findViewById(R.id.editText2);
        editTextResult = findViewById(R.id.result);
    }

    public void Add(View view) {
        String Val1 = editTextValue1.getText().toString();
        String Val2 = editTextValue2.getText().toString();
        double mResult = mCalculator.Adding(Double.valueOf(Val1), Double.valueOf(Val2));
        editTextResult.setText(String.valueOf(mResult));
        Log.d("Debug", "Hello Debug");

    }

    public void Sub(View view) {
        String Val1 = editTextValue1.getText().toString();
        String Val2 = editTextValue2.getText().toString();
        double mResult = mCalculator.Subtracting(Double.valueOf(Val1), Double.valueOf(Val2));
        editTextResult.setText(String.valueOf(mResult));
        Log.d("Debug", "Hello Debug");
    }

    public void Mul(View view) {
        String Val1 = editTextValue1.getText().toString();
        String Val2 = editTextValue2.getText().toString();
        double mResult = mCalculator.Multiply(Double.valueOf(Val1), Double.valueOf(Val2));
        editTextResult.setText(String.valueOf(mResult));
        Log.d("Debug", "Hello Debug");
    }

    public void Div(View view) {
        String Val1 = editTextValue1.getText().toString();
        String Val2 = editTextValue2.getText().toString();
        double mResult = mCalculator.Division(Double.valueOf(Val1), Double.valueOf(Val2));
        editTextResult.setText(String.valueOf(mResult));
        Log.d("Debug", "Hello Debug");
    }

}