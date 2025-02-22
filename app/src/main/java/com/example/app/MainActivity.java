package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private EditText username, password, confirmPassword;
    private Button register, signIn;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.userNameEditText);
        password = findViewById(R.id.passwordEditText);
        confirmPassword = findViewById(R.id.confirmPasswordEditText);
        register = findViewById(R.id.registerBtn);
        signIn = findViewById(R.id.signInBtn);

        dbHelper = new DBHelper(MainActivity.this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString(); //you can't name both passowrds
                String confPass = confirmPassword.getText().toString();

                if(user.equals("") || pass.equals("") || confPass.equals("")) //any of the boxes is empty
                    Toast.makeText(MainActivity.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                else {
                    if(pass.equals(confPass)) {
                        if(!dbHelper.userExists(user)) //user doesn't exist
                        {
                            boolean insert = dbHelper.addUser(user, pass);
                            if(insert) {
                                Toast.makeText(MainActivity.this, "User registered", Toast.LENGTH_SHORT).show();
                                SharedPreferences sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor =sharedPreferences.edit();

                                editor.putString("username", user);
                                editor.putString("password", pass);
                                editor.apply();

                                ///////
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setTitle("Terms and conditions");
                                builder.setMessage("In order to navigate through our app " +
                                        "we need you to agree to our terms and conditions");



                                builder.setPositiveButton("Agree", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(MainActivity.this, OnLogin.class);
//                                intent.putExtra("usernamePass", new String[]{user, pass});
                                        startActivity(intent);


                                    }
                                });

                                builder.create().show();


                               //////

                            } else {
                                Toast.makeText(MainActivity.this, "Failed to register user!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "User already exits, Sign in!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Passwords do no match", Toast.LENGTH_SHORT).show();
                    }

                }
//                Intent intent = new Intent(MainActivity.this, OnLogin.class);
//                startActivity(intent);
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginPageActivity.class);
                startActivity(intent);
            }
        });

//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
//        bottomNavigationView.setSelectedItemId(R.id.home);
//
//        HomeFragment homeFragment = new HomeFragment();
//        PlaygroundFragment playgroundFragment = new PlaygroundFragment();
//        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, homeFragment).commit();
//        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
////                System.out.println("ItemId: " + item.getItemId());
//                switch (item.getItemId()){
//                    case R.id.home:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, new HomeFragment()).commit();
//                        return true;
//
//                    case R.id.playground:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, new PlaygroundFragment()).commit();
//                        return true;
//
//                    case R.id.person:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, new PersonFragment()).commit();
//                        return true; //this will change the color to show that is clicked
//                }
//                return false;
//            }
//        });
    }


}