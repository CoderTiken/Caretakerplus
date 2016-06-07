package com.example.tiken.caretakerfinal;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void clearLogin(View v){
        EditText name = (EditText)findViewById(R.id.namefield);
        EditText password = (EditText)findViewById(R.id.passwordfield);
        name.setText("");
        password.setText("");

    }

    public void newUserBegin(View v){
        Intent intent = new Intent(this,NewUserName.class);
        startActivity(intent);

    }

    public void loginBegin(View v){
        String demo = "demo";
        String demoP = "password";
        EditText name = (EditText)findViewById(R.id.namefield);
        EditText password = (EditText)findViewById(R.id.passwordfield);
        if(name.equals(demo) && (password.equals(demoP))){
            Intent intent = new Intent(this,Demo.class);
            startActivity(intent);

        }
        else{
            TextView errorview = (TextView)findViewById(R.id.errorLogin);
            errorview.setText(R.string.errorLoginMessage);
            errorview.setTextColor(Color.RED);
        }
    }
}
