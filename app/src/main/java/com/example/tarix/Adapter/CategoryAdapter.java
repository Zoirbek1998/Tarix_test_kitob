package com.example.tarix.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tarix.Class.DbQuery;
import com.example.tarix.Model.CategoryModel;
import com.example.tarix.QuizActivity.TestActivity;
import com.example.tarix.R;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {

    List<CategoryModel> cat_list;
    Context context;

    public CategoryAdapter(List<CategoryModel> cat_list, Context context) {
        this.cat_list = cat_list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return cat_list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View myview;
        if (convertView == null) {
            myview = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_item_list, parent, false);
        } else {
            myview = convertView;
        }

        myview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbQuery.g_selected_cat_index = position;
                Intent intent = new Intent(v.getContext(), TestActivity.class);

                context.startActivity(intent);
            }
        });

        TextView catName = myview.findViewById(R.id.cat_name);
        TextView toofTests = myview.findViewById(R.id.of_test);

        catName.setText(cat_list.get(position).getName());
        toofTests.setText(String.valueOf(cat_list.get(position).getNoofTests()));

        return myview;
    }
}
