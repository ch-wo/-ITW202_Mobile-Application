package edu.gcit.todo_7;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    int Count;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = findViewById(R.id.textView_count);

        if(savedInstanceState != null){
            mCount = savedInstanceState.getInt("CountPlus");
            mShowCount.setText(toString().valueOf(mCount));
        }
    }
    public void CountUp(View view) {
        mCount = mCount + 1;
        if(mShowCount != null){
            mShowCount.setText(Integer.toString(mCount));
        }
        Count = mCount;
    }
    @Override
    protected void onSaveInstanceState(Bundle bundle){
        super.onSaveInstanceState(bundle);
        bundle.putInt("CountPlus", Count);
    }
}