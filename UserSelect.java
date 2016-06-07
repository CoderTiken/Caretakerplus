package com.example.tiken.caretakerfinal;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;


public class UserSelect extends AppCompatActivity {
    String filename;
    public final static String FileName="Caretaker.filename";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_select);
        Intent intent = getIntent();
        filename =intent.getStringExtra(NewUserName.FileName);
    }

    public void caretakerSetUp(View v){
        TextView textview =(TextView)findViewById(R.id.futureupdate);
        textview.setTextColor(Color.RED);
    }

    public void userSetup(View v){
        String filedata = (filename+"data");
        String userselect = (filename+"user");
        SharedPreferences sharedPref = getSharedPreferences(filename, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(userselect,true);//if the user select is true, this is a user
        editor.commit();
        Intent intent = new Intent(this,Medicine.class);
        intent.putExtra(FileName,filename);
        startActivity(intent);

    }
}
