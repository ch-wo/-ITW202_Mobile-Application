package edu.gcit.todo_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mValue1;
    private EditText mValue2;
    private TextView mResult;
    private Calculator mCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mValue1 = findViewById(R.id.textval1);
        mValue2 = findViewById(R.id.textval2);
        mResult = findViewById(R.id.resulttxt);
        mCalculate = new Calculator();
    }

    public void Add(View view) {
        String v1 = mValue1.getText().toString();
        String v2 = mValue2.getText().toString();

        double res = mCalculate.adding(Double.valueOf(v1),Double.valueOf(v2));
        mResult.setText(String.valueOf(res));

        Log.d("Debugging","Hello Debugging");
    }

    public void Sub(View view) {
        String v1 = mValue1.getText().toString();
        String v2 = mValue2.getText().toString();

        double res = mCalculate.subtracting(Double.valueOf(v1),Double.valueOf(v2));
        mResult.setText(String.valueOf(res));

        Log.d("Debugging","Hello Debugging");
    }

    public void Mul(View view) {
        String v1 = mValue1.getText().toString();
        String v2 = mValue2.getText().toString();

        double res = mCalculate.multiplying(Double.valueOf(v1),Double.valueOf(v2));
        mResult.setText(String.valueOf(res));

        Log.d("Debugging","Hello Debugging");
    }

    public void Div(View view) {
        String v1 = mValue1.getText().toString();
        String v2 = mValue2.getText().toString();

        double res = mCalculate.dividing(Double.valueOf(v1),Double.valueOf(v2));
        mResult.setText(String.valueOf(res));

        Log.d("Debugging","Hello Debugging");
    }
}