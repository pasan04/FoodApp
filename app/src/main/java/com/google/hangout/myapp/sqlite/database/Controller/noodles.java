package com.google.hangout.myapp.sqlite.database.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.hangout.myapp.R;

public class noodles extends AppCompatActivity {

    public static final String type1 ="finediner";
    public static final String quantity1 ="findiner12";
    public static final String price1 ="finediner123";

    public Button but1;

    double total =0;

    public void init(){

        but1 = (Button)findViewById(R.id.button1);


        but1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                Intent t123= new Intent(noodles.this,lunch_time.class);
                startActivity(t123);


            }


        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        double e1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noodles);
        Intent receiveIntent = this.getIntent();
        String sTax = receiveIntent.getStringExtra(breakfast.Extra_Message);
        TextView textView1 = findViewById(R.id.textresult1);
        textView1.setText(sTax);


        final String quantity12 = receiveIntent.getStringExtra(breakfast.quantity);
        TextView textView2 = findViewById(R.id.textresult2);
        textView2.setText(quantity12);



        String price = receiveIntent.getStringExtra(breakfast.pricePerItem);
        double price12 = Double.parseDouble(price);
        double salesTax = Double.parseDouble(sTax);
        double qty12 = Double.parseDouble(quantity12);

        total = price12*qty12 +salesTax;

        final String total12 =String.valueOf(total);
        TextView textresult = findViewById(R.id.textresult3);
        textresult.setText(total12);

        Switch simpleSwitch = (Switch) findViewById(R.id.switch1);
        Boolean switchState = simpleSwitch.isChecked();
        simpleSwitch.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            Toast.makeText(noodles.this,"Switch On", Toast.LENGTH_SHORT).show();
                            //init();
                            but1 = (Button)findViewById(R.id.button1);
                            but1.setOnClickListener(new View.OnClickListener(){

                                @Override
                                public void onClick(View view){

                                    Intent t123= new Intent(noodles.this,OrderDetails.class);
                                    t123.putExtra(quantity1,quantity12);
                                    t123.putExtra(type1,"Noodles");
                                    t123.putExtra(price1,total12);
                                    startActivity(t123);

                                }
                            });

                        } else {

                            but1 = (Button)findViewById(R.id.button1);
                            but1.setOnClickListener(new View.OnClickListener(){

                                @Override
                                public void onClick(View view){
                                    Toast.makeText(noodles.this,"Please add to bag", Toast.LENGTH_SHORT).show();

                                }
                            });

                        }
                    }
                });

    }
}
