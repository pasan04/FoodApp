package com.google.hangout.myapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class roti extends AppCompatActivity {


    public Button but1;

    public void init(){

        but1 = (Button)findViewById(R.id.button1);
        but1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                Intent t123= new Intent(roti.this,breakfast_time.class);
                startActivity(t123);

            }


        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roti);
        Intent receiveIntent = this.getIntent();
        String sTax = receiveIntent.getStringExtra(breakfast.Extra_Message);
        TextView textView1 = findViewById(R.id.textresult1);
        textView1.setText(sTax);


        String quantity = receiveIntent.getStringExtra(breakfast.quantity);
        TextView textView2 = findViewById(R.id.textresult2);
        textView2.setText(quantity);
        String price = receiveIntent.getStringExtra(breakfast.pricePerItem);
        double price12 = Double.parseDouble(price);
        double salesTax = Double.parseDouble(sTax);
        double qty12 = Double.parseDouble(quantity);

        double total = price12*qty12 +salesTax;

        String total12 =String.valueOf(total);
        TextView textresult = findViewById(R.id.textresult3);
        textresult.setText(total12);

        Switch simpleSwitch = (Switch) findViewById(R.id.switch1);
        Boolean switchState = simpleSwitch.isChecked();
        simpleSwitch.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            Toast.makeText(roti.this,"Switch On", Toast.LENGTH_SHORT).show();
                            //init();
                            but1 = (Button)findViewById(R.id.button1);
                            but1.setOnClickListener(new View.OnClickListener(){

                                @Override
                                public void onClick(View view){

                                    Intent t123= new Intent(roti.this,breakfast_time.class);
                                    startActivity(t123);

                                }
                            });

                        } else {

                            but1 = (Button)findViewById(R.id.button1);
                            but1.setOnClickListener(new View.OnClickListener(){

                                @Override
                                public void onClick(View view){
                                    Toast.makeText(roti.this,"Please add to bag", Toast.LENGTH_SHORT).show();

                                }
                            });

                        }
                    }
                });



    }
}
