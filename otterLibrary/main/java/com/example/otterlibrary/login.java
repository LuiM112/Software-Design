package com.example.otterlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.otterlibrary.databinding.ActivityLoginBinding;

import java.util.List;

public class login extends AppCompatActivity {

    private static final String TAG = "Login";
    private ActivityLoginBinding binding;
    private UsernameDatabase db;
    private TextView usernameTextView;
    private List<Username> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.Login.setOnClickListener(view -> {
            EditText cinput;
            String username;
            String password;
            TextView result;

            cinput = findViewById(R.id.userLoginInput);
            username = cinput.getText().toString();
            Log.d(TAG, username);
            cinput = findViewById(R.id.passwordLoginInput);
            password = cinput.getText().toString();
            Log.d(TAG, password);

            if(username.equals("!admin2") && password.equals("!admin2")){
                Intent i = new Intent(this, ManageSystem.class);
                startActivity(i);
            }
            else{
                Bundle extraInfo = new Bundle();
                Intent i = new Intent(this, MainActivity.class);
                extraInfo.putString("Message", "Incorrect Logins");
                i.putExtras(extraInfo);
                startActivity(i);
            }
        });

    }
}