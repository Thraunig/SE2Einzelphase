package com.example.thoma.se2einzelphaseraunig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "PalindromMessage";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//
    public void checkPalindrom(View view) {

        //EditText aus View in diese Klasse "holen" referenzieren R= Textelement EditText, id = Schlüsselwort
        EditText eingabe = (EditText) findViewById(R.id.inputWort);

        //Abholen und casten als String
        String wort = eingabe.getText().toString();
        if(wort.length() == 0){
            TextView    meldung = (TextView) findViewById(R.id.Textviewfehler);
            String fehlermeldung = "Es wurde ein Leerstring eingegeben."+ "\n"+ "Bitte geben Sie ein Wort ein";
            meldung.setText(fehlermeldung);

        }
        else if (wort.length() < 5){
            TextView    meldung = (TextView) findViewById(R.id.Textviewfehler);
            String fehlermeldung = "Texteingabe zu Kurz!!! Bitte mindestenst 5 Zeichen eingeben";
            meldung.setText(fehlermeldung);
        }
        else   {
            boolean ispal = isPalindrome(wort);

            String message;
            if(ispal){
                message = "Ihr Wort " + wort + " ist EIN Palindrom";
            }
            else{
                message = "Ihr Wort " + wort + " ist KEIN Palindrom";
            }


            Intent intent = new Intent(this, ErgebnisActivity.class);
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }




    }

     //von der LV Leitung vorgegebener Checker
    public static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
