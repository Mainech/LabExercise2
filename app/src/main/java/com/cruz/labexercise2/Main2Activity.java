package com.cruz.labexercise2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnSave, btnSave2, btnDisplay, btnDisplay2;
    TextView tvDisplay, tvDisplay1;
    SharedPreferences preferences;
    String username_string, password_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etUsername = (EditText) findViewById(R.id.et_Username);
        etPassword = (EditText) findViewById(R.id.et_Password);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnDisplay = (Button) findViewById(R.id.btn_display);
        tvDisplay = (TextView) findViewById(R.id.tv_display);
        tvDisplay1 = (TextView) findViewById(R.id.tv_display1);
        preferences = getSharedPreferences("test", Context.MODE_PRIVATE);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        username_string = extras.getString("EXTRA_USERNAME");
        password_string = extras.getString("EXTRA_PASSWORD");
    }

    public void toBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void loadInfo(View view){
        preferences = getSharedPreferences("test", Context.MODE_PRIVATE);
        String user = preferences.getString("username","");
        String pwd = preferences.getString("password", "");
        tvDisplay.setText("The Username is " + user + " and the Password is " + pwd);
        tvDisplay1.setText("Shared Preference");

    }

    public void loadInfo2(View view){
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        username_string = extras.getString("EXTRA_USERNAME");
        password_string = extras.getString("EXTRA_PASSWORD");
        tvDisplay.setText("USERNAME is " + username_string + " and PASSWORD is " + password_string);
        tvDisplay1.setText("INTERNAL STORAGE");
    }


    public void clearAll(View view){
        tvDisplay = (TextView) findViewById(R.id.tv_display);
        tvDisplay.setText("");
        tvDisplay1 = (TextView) findViewById(R.id.tv_display1);
        tvDisplay1.setText("");
    }
}
