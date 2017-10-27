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


public class MainActivity extends AppCompatActivity {


    EditText etUsername, etPassword;
    Button btnSave, btnSave2;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = (EditText) findViewById(R.id.et_Username);
        etPassword = (EditText) findViewById(R.id.et_Password);
        btnSave = (Button) findViewById(R.id.btn_save);
        preferences = getPreferences(Context.MODE_PRIVATE);

    }

    public void saveInfo(View view) {
        preferences = getSharedPreferences("test", Context.MODE_PRIVATE);  //getPreferences(Context.MODE_PRIVATE);
        etUsername = (EditText) findViewById(R.id.et_Username);
        etPassword = (EditText) findViewById(R.id.et_Password);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", etUsername.getText().toString());
        editor.putString("password", etPassword.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data Saved in Shared Preferences!", Toast.LENGTH_SHORT).show();
    }

    public void saveInfo2(View view) {
        Toast.makeText(this, "Data Saved in Internal Storage!", Toast.LENGTH_SHORT).show();
    }


    public void toNext(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        Bundle extras = new Bundle();
        etUsername = (EditText) findViewById(R.id.et_Username);
        etPassword = (EditText) findViewById(R.id.et_Password);
        extras.putString("EXTRA_USERNAME", etUsername.getText().toString());
        extras.putString("EXTRA_PASSWORD", etPassword.getText().toString());
        intent.putExtras(extras);
        startActivity(intent);
    }
}