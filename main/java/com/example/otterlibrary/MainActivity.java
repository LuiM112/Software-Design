package com.example.otterlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.otterlibrary.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String Text = "";

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            Text = extras.getString("Message");
        }

        String message = Text;

        Toast.makeText(this,message, Toast.LENGTH_LONG).show();

        binding.createAccount.setOnClickListener(view ->{
            Intent i = new Intent(this, CreateAccountManage.class);
            startActivity(i);
        });

        binding.placeholder.setOnClickListener(view ->{
            Intent i = new Intent(this, placeholdManage.class);
            startActivity(i);
        });

        binding.Manage.setOnClickListener(view ->{
            Intent i = new Intent(this, login.class);
            startActivity(i);
        });


    }
}