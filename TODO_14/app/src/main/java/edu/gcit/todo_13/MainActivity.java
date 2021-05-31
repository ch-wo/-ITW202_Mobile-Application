package edu.gcit.todo_13;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "todo_13.extra.MESSAGE";
    String text;
    private TextView mOrderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()) {
            case R.id.action_order:
                Intent intent = new Intent(this, MainActivity2.class);
                intent.putExtra(EXTRA_MESSAGE, text);
                startActivity(intent);
                return true;

            case R.id.action_setting:
                return true;

            case R.id.action_favourite:
                displayToast("You selected Favorite.");
                return true;

            case R.id.action_shopping:
                displayToast("You selected Shopping");
                return true;
        }
        return false;
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
    public void donutToast(View view) {
        text = getString(R.string.Donut_Order);
        displayToast(text);
    }

    public void icSandwichesToast(View view) {
        text = getString(R.string.iceCream_Order);
        displayToast(text);
    }

    public void froyoToast(View view) {
        text = getString(R.string.Froyo_Order);
        displayToast(text);
    }

    public void orderDessert(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(EXTRA_MESSAGE, text);
        startActivity(intent);
    }

}