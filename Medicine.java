package com.example.tiken.caretakerfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Medicine extends AppCompatActivity {
    int i=0;
    String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

    }

    public void clear(View v){
        EditText medicine = (EditText)findViewById(R.id.MedicineName);
        EditText amount = (EditText)findViewById(R.id.AmountText);
        EditText alarm1 = (EditText)findViewById(R.id.Alarm1);
        EditText alarm2 = (EditText)findViewById(R.id.Alarm2);
        EditText alarm3 = (EditText)findViewById(R.id.Alarm3);
        EditText alarm4 = (EditText)findViewById(R.id.Alarm4);
        medicine.setText("");
        amount.setText("");
        alarm1.setText("");
        alarm2.setText("");
        alarm3.setText("");
        alarm4.setText("");

    }

    public void cancel(View v){
        finish();
    }

    public void negative(View v){
        if(i>0){
            EditText amount=(EditText)findViewById(R.id.AmountText);
            i--;
            amount.setText(Integer.toString(i));
        }
    }

    public void positive(View v){
        EditText amount=(EditText)findViewById(R.id.AmountText);
        i++;
        amount.setText(Integer.toString(i));
    }

    public void AddMore(View v){
        Intent intent= new Intent(this,Medicine.class);
        finish();
        startActivity(intent);

    }

    public void finish_med(View v){
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }
}
