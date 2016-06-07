package com.example.tiken.caretakerfinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.content.SharedPreferences;
import android.content.Intent;
import android.widget.TextView;

public class NewUserName extends AppCompatActivity {
    public final static String FileName="Caretaker.filename";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_name);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void submit(View v) {
        EditText name = (EditText) findViewById(R.id.NewNameText);
        EditText password = (EditText) findViewById(R.id.NewPasswordText);
        String fileStart;//this will be the prefix for all saved files for the user

        String user_name = name.getText().toString();
        String user_password = password.getText().toString();
        String filename;
        if (user_name != null) {
            if ((user_name.length() > 2) && (user_password.length() > 2)) {
                fileStart = user_name.substring(0, 2);
                filename = fileStart + "data";//this will be the start of all files
                SharedPreferences sharedPref = getSharedPreferences(filename, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString((fileStart + "name"), user_name);
                editor.putString((fileStart + "password"), user_password);
                editor.commit();
                Intent intent = new Intent(this, UserSelect.class);
                intent.putExtra(FileName, fileStart);
                startActivity(intent);
            } else {
                TextView texterror = (TextView) findViewById(R.id.errorNewName);
                texterror.setText(R.string.errorNameMessage);

            }
        } else{
            TextView texterror=(TextView)findViewById(R.id.errorNewName);
            texterror.setText(R.string.errorNameMessage);
        }
    }

    public void clearSubmit(View v){
        EditText name = (EditText)findViewById(R.id.NewNameText);
        EditText password = (EditText)findViewById(R.id.NewPasswordText);
        name.setText("");
        password.setText("");

    }

    public void cancelSubmit(View v){
        finish();
    }

}
