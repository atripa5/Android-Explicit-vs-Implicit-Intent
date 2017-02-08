package com.example.abhi.cs478_project1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Explicit_Intent_Activity extends AppCompatActivity {
    EditText mEdit;
    String EditText_contents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit__intent_);

    }



    public void Dialer(View view) {

        mEdit = (EditText)findViewById(R.id.dialer);
        EditText_contents= mEdit.getText().toString();
        TextView t3= (TextView) findViewById(R.id.textView3);

        //Pattern p = Pattern.compile("^((\\d{3}-|\\(\\d{3}\\)\\s?)?\\d{3}-|^\\d{3}(\\.)?\\d{3}\\3)\\d{4}$");
        Pattern p = Pattern.compile("((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}");
        Matcher m = p.matcher(EditText_contents);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        if(m.find()) {
            String number = m.group().toString();
            intent.setData(Uri.fromParts("tel",number, null));
            startActivity(intent);

            Intent resultIntent = new Intent();

            resultIntent.putExtra("123", "Valid phone number found!");
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
                    }
        else
        {

            int redcolor= Color.RED;
            t3.setTextColor(redcolor);
            t3.setText("No valid phone number found to open dialer");
        }






    }
}
