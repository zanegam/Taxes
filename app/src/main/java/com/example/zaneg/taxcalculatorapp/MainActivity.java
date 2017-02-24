package com.example.zaneg.taxcalculatorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    String response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner status = (Spinner)findViewById(R.id.spnStatus);

        Button start = (Button)findViewById(R.id.btnStart);
        start.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                response = status.getSelectedItem().toString();
                if(response.equals("Single")){
                    startActivity(new Intent(MainActivity.this, Single.class));
                }
                else{
                    startActivity(new Intent(MainActivity.this, Married.class));
                }
            }
        });
    }
}
