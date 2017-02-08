package com.example.abhi.cs478_project1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Explicit_Intent(View view) {
        Intent intent = new Intent(this, Explicit_Intent_Activity.class);
        startActivityForResult(intent, 123);

    }

    TextView tv1;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 123 && resultCode == RESULT_OK && data != null) {
            String result = data.getStringExtra("123");

            tv1 = (TextView) findViewById(R.id.textView2);
            int greencolor= Color.GREEN;
            tv1.setTextColor(greencolor);
            tv1.setText(result);


        }
        else{
            tv1 = (TextView) findViewById(R.id.textView2);
            int redcolor= Color.RED;
            tv1.setTextColor(redcolor);
            tv1.setText("No phone numbers found!");
        }
    }

    public void Android_documentation(View view) {

        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/index.html")));
    }

}
