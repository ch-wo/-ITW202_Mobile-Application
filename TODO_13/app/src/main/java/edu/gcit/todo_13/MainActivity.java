package edu.gcit.todo_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "todo_13.extra.MESSAGE";
    FloatingActionButton floatingActionButton;
    private String mOrderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void donutToast(View view) {
        Toast toast = Toast.makeText(this, "You ordered a donut.", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void icSandwichesToast(View view) {
        Toast toast = Toast.makeText(this, "You ordered a ice cream sandwiches.", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void froyoToast(View view) {
        Toast toast = Toast.makeText(this, "You ordered a froyo.", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void orderDessert(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
        startActivity(intent);
    }

}