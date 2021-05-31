package edu.gcit.todo_22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText nBookInput;
    private TextView mTitleText;
    private TextView  mAuthorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nBookInput = findViewById(R.id.input);
        mTitleText = findViewById(R.id.titleText);
        mAuthorText = findViewById(R.id.authorText);
    }

    public void onClickSearch(View view) {
        String queryString = nBookInput.getText().toString();

        //sending data from fetch book
        new FetchBook(mTitleText, mAuthorText).execute(queryString);

        ConnectivityManager conMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if(conMgr != null){
            networkInfo = conMgr.getActiveNetworkInfo();
        }
        if(networkInfo != null && networkInfo.isConnected() && queryString.length() != 0){
            new FetchBook(mTitleText, mAuthorText).execute(queryString);
            mAuthorText.setText("");
            mTitleText.setText("Loading...");
        }else {
            if(queryString.length() == 0){
                mAuthorText.setText("");
                mTitleText.setText("No search item");
            }else {
                mAuthorText.setText("");
                mTitleText.setText("No network...");
            }
        }
    }
}