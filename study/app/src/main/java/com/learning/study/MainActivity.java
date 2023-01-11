package com.learning.study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static String value = "value";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        System.out.println(intent.getStringExtra(value));
        if (intent.getStringExtra(value) != null)
            Toast.makeText(this, intent.getStringExtra(value), Toast.LENGTH_SHORT).show();
    }

    public void someFunc(View view) {
        TextView textView = (TextView) view;
        Toast.makeText(this, String.valueOf(textView.getText()), Toast.LENGTH_SHORT).show();
    }

    public void buttonFunc(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(value, "extra!!!!!!!!!!!!!!!!!!1");
        startActivity(intent);
    }
}