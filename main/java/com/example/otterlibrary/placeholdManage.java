package com.example.otterlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.otterlibrary.databinding.ActivityCreateAccountManageBinding;

import java.util.List;

public class placeholdManage extends AppCompatActivity {
    private static final String TAG = "placehold";
    private ActivityCreateAccountManageBinding binding;
    private UsernameDatabase db1;
    private TransactionAccountDatabase db2;
    private BooksDatabase db3;
    private TextView usernameTextView;
    private List<Username> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placehold_manage);
    }
}