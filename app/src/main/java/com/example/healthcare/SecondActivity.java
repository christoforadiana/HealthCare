package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class SecondActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        logout = (Button) findViewById(R.id.btnLogout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(SecondActivity.this, LoginActivity.class));
            }
        });
    }

    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(SecondActivity.this, LoginActivity.class));
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch(item.getItemId()){
//            case R.id.button_logout:{
//                Logout();
//            }
//            case R.id.btnLogin:
//                startActivity(new Intent(SecondActivity.this, ContactsContract.Profile.class));
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
