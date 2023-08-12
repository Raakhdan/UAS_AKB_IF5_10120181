package com.example.UAS_AKB_IF5_10120181;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//Akhdan Rafly
//10120181
//IF-5
public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomnavigation;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize fragment
        Fragment fragment = new com.example.UAS_AKB_IF5_10120181.HomeFragment();

        //open Fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,fragment)
                .commit();

        auth = FirebaseAuth.getInstance();
        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = auth.getCurrentUser();
                if (user == null) {
                    startActivity(new Intent(MainActivity.this, com.example.UAS_AKB_IF5_10120181.LoginActivity.class));
                }
            }
        };

        bottomnavigation = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new com.example.UAS_AKB_IF5_10120181.HomeFragment()).commit();
        bottomnavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.home:
                        selectedFragment = new com.example.UAS_AKB_IF5_10120181.HomeFragment();
                        break;
                    case R.id.profile:
                        selectedFragment = new com.example.UAS_AKB_IF5_10120181.ProfileFragment();
                        break;
                    case R.id.info:
                        selectedFragment = new com.example.UAS_AKB_IF5_10120181.InfoFragment();
                        break;
                    case R.id.logout:
                        selectedFragment = new com.example.UAS_AKB_IF5_10120181.LogoutFragment();
                        break;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                return true;
            }


        });



    }
    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        auth.removeAuthStateListener(authListener);
    }
}
// Akhdan Rafly
// 10120181
// IF-5