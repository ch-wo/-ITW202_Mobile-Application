package edu.gcit.todo_21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mtextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtextview = findViewById(R.id.textview1);
    }

    public void startTask(View view) {
        mtextview.setText("Napping.......");
        new SimpleAsyncTask(mtextview).execute();
    }
}