package edu.gcit.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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

    public void Dial(View view) {
        Uri uri = Uri.parse("tel:17824569");
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }
}