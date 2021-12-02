package com.example.tarix.QuizActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tarix.Adapter.TestAdapter;
import com.example.tarix.Class.DbQuery;
import com.example.tarix.Class.MyComplectListener;
import com.example.tarix.R;

public class TestActivity extends AppCompatActivity {
    Toolbar toolbarTes;
    RecyclerView recView;
    private  TestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        toolbarTes = findViewById(R.id.toolbar2);

        setSupportActionBar(toolbarTes);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        getSupportActionBar().setTitle(DbQuery.g_catList.get(DbQuery.g_selected_cat_index).getName());
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recView = findViewById(R.id.test_recycler);

        DbQuery.loadTestData(new MyComplectListener() {
            @Override
            public void onSuccess() {
                adapter = new TestAdapter(TestActivity.this,DbQuery.g_testList);
                recView.setAdapter(adapter);
            }

            @Override
            public void onFailere() {
                Toast.makeText(TestActivity.this, "Hatolik yuz berdi iltimos keyinroq urinib ko'ring", Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            TestActivity.this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}