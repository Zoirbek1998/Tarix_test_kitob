package com.example.tarix.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.example.tarix.Adapter.CategoryAdapter;
import com.example.tarix.R;

import static com.example.tarix.Class.DbQuery.g_catList;


public class CaregoryFragment extends Fragment {

    GridView gridView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_caregory, container, false);

        gridView = view.findViewById(R.id.cat_Grid);

       // loatCategory();
        CategoryAdapter adapter = new CategoryAdapter(g_catList,getContext());
        gridView.setAdapter(adapter);

        return view;
    }


}