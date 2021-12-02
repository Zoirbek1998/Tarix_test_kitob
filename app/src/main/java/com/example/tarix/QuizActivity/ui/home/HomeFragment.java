package com.example.tarix.QuizActivity.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.tarix.Fragment.AccountFragment;
import com.example.tarix.Fragment.CaregoryFragment;
import com.example.tarix.Fragment.LeaderBoardFragment;
import com.example.tarix.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class HomeFragment extends Fragment {

    private BottomNavigationView bottomNavigationView;
    FrameLayout main_fram;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        main_fram = root.findViewById(R.id.main_frame);
        bottomNavigationView = root.findViewById(R.id.bottomNavigationView);

        getChildFragmentManager().beginTransaction().add(R.id.main_frame, new CaregoryFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.ic_home:
                        fragment = new CaregoryFragment();
                        break;
                    case R.id.ic_edualezer:
                        fragment = new LeaderBoardFragment();
                        break;
                    case R.id.ic_account:
                        fragment = (new AccountFragment());
                        break;


                }
                getChildFragmentManager().beginTransaction().replace(R.id.main_frame, fragment).commit();
                return true;
            }
        });
        return root;
    }


}