package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPageActivity extends AppCompatActivity {

    static SharedPreferences sharedPreferences;

    private EditText username, password;
    private Button signIn;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        username = findViewById(R.id.userNameEditText);
        password = findViewById(R.id.passwordEditText);
        signIn = findViewById(R.id.signInBtn);
        dbHelper = new DBHelper(LoginPageActivity.this);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals(""))
                    Toast.makeText(LoginPageActivity.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                else {
                    if(dbHelper.checkUsernamePassword(user, pass)){
                        sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor =sharedPreferences.edit();

                        editor.putString("username", user);
                        editor.putString("password", pass);
                        editor.apply();

                        Toast.makeText(LoginPageActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginPageActivity.this, OnLogin.class);
//                        intent.putExtra("usernamePass", new String[]{user, pass});
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginPageActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}