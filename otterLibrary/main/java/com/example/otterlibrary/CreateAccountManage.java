package com.example.otterlibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.otterlibrary.databinding.ActivityCreateAccountManageBinding;

import java.util.List;

public class CreateAccountManage extends AppCompatActivity {

    private static final String TAG = "CreateAccount";
    private ActivityCreateAccountManageBinding binding;
    private UsernameDatabase db;
    private TransactionAccountDatabase db2;
    private TextView usernameTextView;
    private List<Username> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateAccountManageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.accountCreate.setOnClickListener(view -> {
            EditText cinput;
            String username;
            String password;

            cinput = findViewById(R.id.userInput);
            username = cinput.getText().toString();
            Log.d(TAG, username);
            cinput = findViewById(R.id.passwordInput);
            password = cinput.getText().toString();
            Log.d(TAG, password);

            db = UsernameDatabase.getInstance(this);
            db.populateInitialData();
            userList = db.info().getAll();

            boolean check = false;

            db2 = TransactionAccountDatabase.getInstance(this);

            for (int j = 0; j < userList.size(); j++){
                String user = userList.get(j).getUsername();
                if(username.equals(user)){
                    Bundle extraInfo = new Bundle();
                    Intent i = new Intent(this, MainActivity.class);
                    extraInfo.putString("Message", "Username already exist");
                    i.putExtras(extraInfo);
                    startActivity(i);
                    check = true;
                    break;
                }
            }
            if(check == false){
                Username newAccount = new Username(username,password);
                db.info().addAccount(newAccount);
                TransactionAccount newTransaction = new TransactionAccount("New Account",username);
                db2.info().addAccount(newTransaction);
                Bundle extraInfo = new Bundle();
                Intent i = new Intent(this, MainActivity.class);
                extraInfo.putString("Message", "Account has been created");
                i.putExtras(extraInfo);
                startActivity(i);
            }
        });



    }
}