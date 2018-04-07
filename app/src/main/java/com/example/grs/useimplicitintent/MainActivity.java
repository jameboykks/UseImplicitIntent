package com.example.grs.useimplicitintent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3;
    Button button4, button5, button6;
    Button button7, button8, button9;
    Button button0, buttonStar, buttonClear;
    TextView numberView;
    Button call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberView = (TextView) findViewById(R.id.number_display);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button0 = (Button) findViewById(R.id.button0);
        buttonStar = (Button) findViewById(R.id.button_star);
        buttonClear = (Button) findViewById(R.id.button_clear);
        button1.setOnClickListener(this.appendString("1"));
        button2.setOnClickListener(this.appendString("2"));
        button3.setOnClickListener(this.appendString("3"));
        button4.setOnClickListener(this.appendString("4"));
        button5.setOnClickListener(this.appendString("5"));
        button6.setOnClickListener(this.appendString("6"));
        button7.setOnClickListener(this.appendString("7"));
        button8.setOnClickListener(this.appendString("8"));
        button9.setOnClickListener(this.appendString("9"));
        button0.setOnClickListener(this.appendString("0"));
        buttonStar.setOnClickListener(this.appendString("*"));
        buttonClear = (Button) findViewById(R.id.button_clear);
        call=(Button)findViewById(R.id.button);
        call();

        buttonClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numberView.setText("");
            }
        });
        Button mDialButton = (Button) findViewById(R.id.button);
        final TextView mPhoneNoEt = (TextView) findViewById(R.id.number_display);
        mDialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNo = mPhoneNoEt.getText().toString();
                if(!TextUtils.isEmpty(phoneNo)) {
                    String dial = "tel:" + phoneNo;
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
                }else {
                    Toast.makeText(MainActivity.this, "Enter a phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @SuppressLint("MissingPermission")
    private void call() {
        Intent in=new Intent(Intent.ACTION_CALL, Uri.parse("123123"));
        try{
            startActivity(in);
        }

        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
        }
    }


    public View.OnClickListener appendString(final String number) {
        return new View.OnClickListener() {
            public void onClick(View arg0) {
                numberView.append(number);
            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

