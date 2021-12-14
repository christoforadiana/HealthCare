package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public CardView card1, card2, card3, card4;
    public Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences.Editor editor = getSharedPreferences("TxUsername", MODE_PRIVATE).edit();
        editor.putString("TxPassword", "");
        editor.apply();

        card1 = (CardView) findViewById(R.id.c1);
        card2 = (CardView) findViewById(R.id.c2);
        card3 = (CardView) findViewById(R.id.c3);
        card4 = (CardView) findViewById(R.id.c4);
        logout = (Button) findViewById(R.id.btnLogout);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.c1:
                i = new Intent(this,BeratBadanIdealActivity.class);
                startActivity(i);
                break;
            case R.id.c2:
                i = new Intent(this,MenuMakananSehatActivity.class);
                startActivity(i);
                break;
            case R.id.c3:
                i = new Intent(this,TipsDietActivity.class);
                startActivity(i);
                break;
            case R.id.c4:
                i = new Intent(this,OlahragaActivity.class);
                startActivity(i);
                break;
            case R.id.btnLogout:
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.putExtra("finish", true);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

                finish();
        }
    }




}