package com.example.tarix.QuizActivity;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tarix.Model.QuestionModel;
import com.example.tarix.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class QuestionsActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textSavol, Qcount, time;
    MaterialButton btn1, btn2, btn3, btn4;
    List<QuestionModel> questionModelList = new ArrayList<>();
    int questionNum;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        initViews();
        getQuestionList();
    }


    private void initViews() {
        time = findViewById(R.id.time_id);
        Qcount = findViewById(R.id.count_id);
        textSavol = findViewById(R.id.test_savol);

        btn1 = findViewById(R.id.test_id1);
        btn2 = findViewById(R.id.test_id2);
        btn3 = findViewById(R.id.test_id3);
        btn4 = findViewById(R.id.test_id4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    private void getQuestionList() {
        questionModelList = new ArrayList<>();

        questionModelList.add(new QuestionModel("Question 1", "A", "B", "C", "D", 2));
        questionModelList.add(new QuestionModel("Question 2", "B", "A", "D", "C", 2));
        questionModelList.add(new QuestionModel("Question 3", "D", "B", "A", "C", 2));
        questionModelList.add(new QuestionModel("Question 4", "C", "D", "B", "A", 2));
        questionModelList.add(new QuestionModel("Question 5", "C", "D", "A", "B", 2));

        setQuestions();
    }

    private void setQuestions() {

        time.setText(String.valueOf(30));
        textSavol.setText(questionModelList.get(0).getQuestion());
        btn1.setText(questionModelList.get(0).getOptionA());
        btn2.setText(questionModelList.get(0).getOptionB());
        btn3.setText(questionModelList.get(0).getOptionC());
        btn4.setText(questionModelList.get(0).getOptionD());

        Qcount.setText(String.valueOf(1) + "/" + String.valueOf(questionModelList.size()));

        startTime();
        questionNum = 0;
    }

    private void startTime() {

         countDownTimer = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                changeQuestions();
            }
        };
        countDownTimer.start();
    }


    @Override
    public void onClick(View v) {
        int selectedOption = 0;

        switch (v.getId()) {

            case R.id.test_id1:
                selectedOption = 1;
                break;

            case R.id.test_id2:
                selectedOption = 2;
                break;

            case R.id.test_id3:
                selectedOption = 3;
                break;

            case R.id.test_id4:
                selectedOption = 4;
                break;
            default:
        }
        countDownTimer.cancel();
        checkAnswer(selectedOption,v);
    }

    private void checkAnswer(int selectedOption,View view) {

        if (selectedOption == questionModelList.get(questionNum).getCorrecticAns()) {
            //Right Aniwer
            ((MaterialButton)view ).setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        } else {
            //Wrong Aniwer
            ((MaterialButton)view ).setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            switch (questionModelList.get(questionNum).getCorrecticAns()){
                case 1:
                    btn1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                case 2:
                    btn1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                case 3:
                    btn1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                case 4:
                    btn1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            }
        }
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                changeQuestions();
            }
        },2000);

    }

    private void changeQuestions() {

        if (questionNum < questionModelList.size() - 1) {
            questionNum++;
            playAnim(textSavol,0,0);
            playAnim(btn1,0,1);
            playAnim(btn2,0,2);
            playAnim(btn3,0,3);
            playAnim(btn4,0,4);

            Qcount.setText(String.valueOf(questionNum+1) + "/" + String.valueOf(questionModelList.size()));

            time.setText(String.valueOf(30));
            startTime();

        } else {
            startActivity(new Intent(QuestionsActivity.this, ScoreActivity.class));
            finish();
        }
    }

    private void playAnim(View view,final int value,int viewNum) {
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
                .setStartDelay(100).setInterpolator(new DecelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (value==0){
                            switch (viewNum){
                                case 0:
                                    ((TextView)view).setText(questionModelList.get(questionNum).getQuestion());
                                case 1:
                                    ((MaterialButton)view).setText(questionModelList.get(questionNum).getOptionA());
                                case 2:
                                    ((MaterialButton)view).setText(questionModelList.get(questionNum).getOptionB());
                                case 3:
                                    ((MaterialButton)view).setText(questionModelList.get(questionNum).getOptionC());
                                case 4:
                                    ((MaterialButton)view).setText(questionModelList.get(questionNum).getOptionD());
                            }

                            if (viewNum !=0)
                                ((MaterialButton)view).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#f2f5f8")));
                            playAnim(view,1,viewNum);
                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }
}