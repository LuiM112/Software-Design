package com.example.otterlibrary;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.os.Bundle;

import com.example.otterlibrary.databinding.ActivityManageSystemBinding;

import java.util.List;

public class ManageSystem extends AppCompatActivity {
    private ActivityManageSystemBinding binding;
    private TransactionAccountDatabase db1;
    private TransactionBooksDatabase db2;
    private BooksDatabase db3;
    private ListView AccountListView;
    private ListView transactionListView;
    private ListView booksListView;
    private List<TransactionAccount> accountList;
    private List<TransactionBooks> transactionList;
    private List<Books> booksList;
    private ArrayAdapter<TransactionAccount> accountAdapter;
    private ArrayAdapter<TransactionBooks> transactionBooksAdapter;
    private ArrayAdapter<Books> booksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityManageSystemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db1 = TransactionAccountDatabase.getInstance(this);
        AccountListView = binding.AccountList;
        accountList = db1.info().getAll();
        accountAdapter = new ArrayAdapter<>(this,R.layout.item_set, R.id.set_item, accountList);
        AccountListView.setAdapter(accountAdapter);


        db3 = BooksDatabase.getInstance(this);
        db3.populateInitialData();
        booksListView = binding.bookList;
        booksList = db3.info().getAll();
        booksAdapter = new ArrayAdapter<>(this,R.layout.item_set, R.id.set_item, booksList);
        booksListView.setAdapter(booksAdapter);


    }

}