package com.example.UAS_AKB_IF5_10120181;

//Akhdan Rafly
//10120181
//IF-5

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassActivity extends AppCompatActivity {
    private EditText inputEmail;
    private Button btnSendResetEmail;
    private TextView btnSignIn;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
        inputEmail = (EditText) findViewById(R.id.email);
        btnSendResetEmail = (Button) findViewById(R.id.send_reset_email_button);
        btnSignIn = (TextView)findViewById(R.id.sign_in_button);

        auth = FirebaseAuth.getInstance();

        btnSendResetEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = inputEmail.getText().toString();

                if (TextUtils.isEmpty(email)){
                    inputEmail.setError("Email harus diisi!");
                }else {
                    auth.sendPasswordResetEmail(email).addOnCompleteListener(ForgotPassActivity.this, new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(ForgotPassActivity.this, "link reset password berhasil dikirim, silahkan cek email anda", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(ForgotPassActivity.this, "password gagal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ForgotPassActivity.this, LoginActivity.class));
            }
        });
    }
}
// Akhdan Rafly
// 10120181
// IF-5