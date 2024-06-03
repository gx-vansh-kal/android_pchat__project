package com.example.prichat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.prichat.Models.Users;
import com.example.prichat.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class Signup extends AppCompatActivity {

    ActivitySignupBinding binding ;
    private FirebaseAuth auth;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // getting email and password from user
                auth.createUserWithEmailAndPassword // Continue
                        (binding.email.getText().toString(),binding.password.getText().toString()).addOnCompleteListener
                            (new OnCompleteListener<AuthResult>() {
                    @Override
//                  checking for exception if the enter value is right or already entered
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if( task.isSuccessful()){
                            //initializing or giving value to user by using constructor
                            Users user = new Users(binding.username.getText().toString(),binding.email.getText().toString(),
                                    binding.password.getText().toString());
                            // getting uid from firebase auth so to use in database
                            String id = task.getResult().getUser().getUid();
                            database.getReference().child("Users").child(id).setValue(user);

                            Toast.makeText(Signup.this, "User Created Successfully", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(Signup.this,MainActivity.class);
                            startActivity(intent);

                        } else {
                            // return with error or exception msg
                            Toast.makeText(Signup.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        
                    }
                });
            }
        });
        binding.alreadySignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup.this,Signin.class);
                startActivity(intent);
            }
        });
    }
}