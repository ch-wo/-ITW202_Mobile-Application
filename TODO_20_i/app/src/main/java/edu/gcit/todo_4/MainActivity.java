package edu.gcit.todo_4;

import androidx.appcompat.app.AppCompatActivity;

import android.telephony.gsm.SmsMessage;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "edu.gcit.todo_4";
    public static final int TEXT_REQUEST = 1;
    private EditText mMessageEditText;
    private TextView mReplyTextView;
    private TextView mReplyText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_main);
        mReplyTextView = findViewById(R.id.textView_reply);
        mReplyText = findViewById(R.id.textView_mReply);

    }
    public void Next(View view) {
        Intent obj = new Intent(this, MainActivity2.class);
        String message = mMessageEditText.getText().toString();
        obj.putExtra(EXTRA_MESSAGE, message);
        //startActivity(obj);
        startActivityForResult(obj, TEXT_REQUEST);
    }
    @Override
    public void onActivityResult(int requestCode, int resultcode, Intent data){
        super.onActivityResult(requestCode, resultcode, data);
        if(requestCode == TEXT_REQUEST){
            if(resultcode == RESULT_OK){
                String reply = data.getStringExtra(MainActivity2.EXTRA_REPLY);
                mReplyTextView.setVisibility(View.VISIBLE);
                mReplyText.setText(reply);
                mReplyText.setVisibility(View.VISIBLE);
            }
        }
    }
}