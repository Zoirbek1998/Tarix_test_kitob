package com.example.tarix.QuizActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tarix.Class.DbQuery;
import com.example.tarix.Class.MyComplectListener;
import com.example.tarix.R;
import com.google.android.material.button.MaterialButton;

import static com.example.tarix.Class.DbQuery.g_catList;
import static com.example.tarix.Class.DbQuery.g_testList;
import static com.example.tarix.Class.DbQuery.loadquestions;

public class StratTestActivity extends AppCompatActivity {

    TextView catName,testNo,totalQ,bestScore,time;
    MaterialButton startTestBtn;
    ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strat_test);

    initViews();

        loadquestions(new MyComplectListener() {
            @Override
            public void onSuccess() {
                setData();
            }

            @Override
            public void onFailere() {

            }
        });
    }



    private void initViews() {
        catName=findViewById(R.id.st_name_cat);
        testNo=findViewById(R.id.st_test_no);
        totalQ=findViewById(R.id.st_total_ques);
        bestScore=findViewById(R.id.st_bast_score);
        time=findViewById(R.id.st_time);
        startTestBtn=findViewById(R.id.start_test_btn);
        backBtn=findViewById(R.id.btn_back);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StratTestActivity.this.finish();
            }
        });

        startTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StratTestActivity.this,QuestionsActivity.class));
            }
        });
    }

    private void setData() {

        catName.setText(g_catList.get(DbQuery.g_selected_cat_index).getName());
        testNo.setText("TEST NO."+String.valueOf(DbQuery.g_selected_cat_index+1));
        totalQ.setText(String.valueOf(g_catList.size()));
        bestScore.setText(String.valueOf(g_catList.get(DbQuery.g_selected_cat_index).getNoofTests()));
        time.setText(String.valueOf(g_testList.get(DbQuery.g_selected_cat_index).getTime()));


    }
}