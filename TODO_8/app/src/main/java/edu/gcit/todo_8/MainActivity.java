package edu.gcit.todo_8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editTextWebsite;
    private EditText editTextLocation;
    private EditText editTextShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextWebsite = findViewById(R.id.website);
        editTextLocation = findViewById(R.id.location);
        editTextShare = findViewById(R.id.share);

    }
    public void web(View view) {
        String message = editTextWebsite.getText().toString();
        Uri url = Uri.parse(message);
        Intent obj = new Intent(Intent.ACTION_VIEW, url);
        if(obj.resolveActivity(getPackageManager()) != null){
            startActivity(obj);
        }
        else{
            Log.d("Implicit intent","Error in opening intent");
        }
    }

    public void location(View view) {
        String txt = editTextLocation.getText().toString();
        Uri url = Uri.parse("geo:0,0?q="+txt);
        Intent obj = new Intent(Intent.ACTION_VIEW, url);
        if (obj.resolveActivity(getPackageManager()) != null){
            startActivity(obj);
        }
        else{
            Log.d("Implicit intent","Error in opening intent");
        }
    }

    public void share(View view) {
        String message = editTextShare.getText().toString();
        String msgType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(msgType)
                .setChooserTitle("Share this text with: ")
                .setText(message)
                .startChooser();
    }
}