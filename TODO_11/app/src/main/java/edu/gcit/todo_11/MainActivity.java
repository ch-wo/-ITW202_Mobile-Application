package edu.gcit.todo_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView mText;
    private String[] mcolorArray = {"purple_200", "purple_500", "purple_700","teal_200","teal_700",
                                    "black", "white", "yellow", "orange", "blue", "pink", "red",
                                    "green","gray", "brown"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText = findViewById(R.id.textView);
    }

    public void changeColor(View view) {
        Random random =new Random();
        String colorName = mcolorArray[random.nextInt(15)];
        int colorResourceName = getResources().getIdentifier(colorName,"color",getApplicationContext().getPackageName());
        int colorRes = ContextCompat.getColor(this, colorResourceName);
        mText.setTextColor(colorRes);
    }
}