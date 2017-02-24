package com.example.zaneg.taxcalculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import java.text.NumberFormat;

public class Single extends AppCompatActivity {
    double taxable, stdDed = 6300, taxes;
    double[] bracket = {9275,   37650,   91150, 190150,   413350,    415050,    415051};
    double[] base =    {   0,  927.50, 5183.75,  18558, 46278.75, 119934.75, 120529.75};
    double[] over =    {   0,    9275,   37650,  91150,   190150,    413350,    415050};
    double[] percent = {0.10,    0.15,    0.25,   0.28,     0.33,      0.35,     0.396};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        final EditText income = (EditText)findViewById(R.id.editTextIncome);
        final RadioButton rdUse = (RadioButton)findViewById(R.id.radioUse);
        final RadioButton rdNo = (RadioButton)findViewById(R.id.radioNo);
        final TextView result = (TextView)findViewById(R.id.txtResult);

        Button show = (Button)findViewById(R.id.btnShow);
        show.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                taxable = Double.parseDouble(income.getText().toString());
                int range = 0;
                if(taxable<0){
                    Toast.makeText(Single.this, "Income must be greater than 0.", Toast.LENGTH_LONG).show();
                }
                else{
                    if(rdUse.isChecked()) {
                        taxable -= stdDed;
                    }
                    for(int i = 0; i<6; i++){
                        if(taxable<=bracket[i]){
                            i = 6;
                        }
                        else{
                            range++;
                        }
                    }
                    taxes = base[range] + ((taxable-over[range])*percent[range]);
                    NumberFormat money = NumberFormat.getCurrencyInstance();
                    if(taxes<0){
                        result.setText(("$0"));
                    }
                    else{
                        result.setText(money.format(taxes));
                    }
                }
            }
        });
    }
}
