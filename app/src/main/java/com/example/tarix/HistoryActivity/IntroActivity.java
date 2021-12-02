package com.example.tarix.HistoryActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.tarix.Adapter.IntroAdapter;
import com.example.tarix.Model.Model;
import com.example.tarix.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {
    ViewPager2 viewPager;
    ExtendedFloatingActionButton Next;
    List<Model> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Next = findViewById(R.id.next);
        viewPager = findViewById(R.id.ViewPager);
        createList();
        IntroAdapter adapter = new IntroAdapter(this, models);
        viewPager.setAdapter(adapter);

    }

    private void createList() {
        models = new ArrayList<>();
        models.add(new Model(R.drawable.bola_2, "Kitob ilim bulog'i", "Kitobni ohirigacha oqing sizlar uchun\n barcha sinf tarix kitoblari \njamlanmasi !!!"));
        models.add(new Model(R.drawable.qizbola_1, "Kitobsiz uy – qalbsiz tanaga o‘xshaydi.", "Yaxshi do‘st, toza vijdon va albatta,\n yaxshi kitoblar – ideal hayot uchun\n boshqa narsa kerak emas! "));
        models.add(new Model(R.drawable.bola_1, "Kitobdek aqlli va sodiq do‘st yo‘q.", "Ma’nan yetuk kitoblarni tanlab o‘qi.\n Aks holda, bir dasta qog‘oz hayotingni\n zaharlashi mumkin."));
        models.add(new Model(R.drawable.qizbola_2, "Shohona, biroq kutubxonasiz uyga achinaman.", "Agar siz o‘qishni xohlagan kitob hali\n yozilmagan bo‘lsa, demak uni yozishni\n boshlashingiz kerak"));

    }

    private void SecondTime() {
        SharedPreferences.Editor editor = getSharedPreferences("MyPref", MODE_PRIVATE).edit();
        editor.putBoolean("secondTime", true);
        editor.apply();
    }


    public void NextImage(View view) {

        if (viewPager.getCurrentItem() == models.size() - 2) {
            Next.setText("Boshlash");
            Next.setIcon(getDrawable(R.drawable.ic_baseline_check_24));
        }
        if (viewPager.getCurrentItem() == models.size() - 1) {
            SecondTime();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
        int item = viewPager.getCurrentItem();
        item = item + 1;
        viewPager.setCurrentItem(item);

    }
}