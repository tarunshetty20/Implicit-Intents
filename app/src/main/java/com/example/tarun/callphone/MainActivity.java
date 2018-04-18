package com.example.tarun.callphone;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    EditText mEditText;
    Button mButton1;
    private Button mbutton2;
    Button mButton3;
    EditText mphonenum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1 = (Button) findViewById(R.id.button1);
        mEditText = (EditText) findViewById(R.id.text1);
        mbutton2 = (Button) findViewById(R.id.buttonCall);
        mButton3 = (Button) findViewById(R.id.buttonclose);
        mphonenum = (EditText) findViewById(R.id.textph);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = mEditText.getText().toString();
                Uri webpage = Uri.parse(message);
                Intent a = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(a);
            }
        });

        mbutton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String number = mphonenum.getText().toString();
                Uri call = Uri.parse(number);
                Intent callIntent = new Intent(Intent.ACTION_DIAL, call);
                callIntent.setData(Uri.parse("tel:" + number));
                startActivity(callIntent);
            }
        });

        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Close App");
                alert.setCancelable(true);
                alert.setMessage("Application will be closed");
                alert.setPositiveButton("Close App", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });
                alert.show();
            }
        });






    }
}
