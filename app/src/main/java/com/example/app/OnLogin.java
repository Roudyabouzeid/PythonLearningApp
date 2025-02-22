package com.example.app;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class OnLogin extends AppCompatActivity {

    static String user, password;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_login);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.home);

//        Intent intent = getIntent();
//        if(intent != null){
//           String [] usernamePass = intent.getStringArrayExtra("usernamePass");
//           user = usernamePass[0];
//           password = usernamePass[1];
//        }
        SharedPreferences sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        user =(sharedPreferences.getString("username",""));
        password = (sharedPreferences.getString("password", ""));
        System.out.println("user: " + user + " password: " + password);


        HomeFragment homeFragment = new HomeFragment();
        PlaygroundFragment playgroundFragment = new PlaygroundFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, homeFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                System.out.println("ItemId: " + item.getItemId());
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, new HomeFragment()).commit();
                        return true;

                    case R.id.playground:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, new PlaygroundFragment()).commit();
                        return true;

                    case R.id.person:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, new PersonFragment()).commit();
                        return true; //this will change the color to show that is clicked
                }
                return false;
            }
        });
    }

}