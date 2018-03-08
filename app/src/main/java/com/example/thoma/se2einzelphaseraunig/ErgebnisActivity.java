package com.example.thoma.se2einzelphaseraunig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ErgebnisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ergebnis);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.TextViewErgebnis);
        textView.setText(message);


    }

    public void getBack(View view) {
        //Intent erzeugen welches Bezug zur MainActivity hat und sie startet
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}
