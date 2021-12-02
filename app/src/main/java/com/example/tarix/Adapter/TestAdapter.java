package com.example.tarix.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tarix.Class.DbQuery;
import com.example.tarix.Model.TestModel;
import com.example.tarix.QuizActivity.StratTestActivity;
import com.example.tarix.R;

import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

    Context context;
    List<TestModel> testModelList;

    public TestAdapter(Context context, List<TestModel> testModelList) {
        this.context = context;
        this.testModelList = testModelList;
    }



    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.test_list_item, parent, false);
        return new TestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
        int progress = testModelList.get(position).getTopScore();
        holder.setData(position, progress);
    }

    @Override
    public int getItemCount() {
        return testModelList.size();
    }

    class TestViewHolder extends RecyclerView.ViewHolder {
        TextView textNo, scoreTest;
        ProgressBar progressBar;

        public TestViewHolder(@NonNull View itemView) {
            super(itemView);

            textNo = itemView.findViewById(R.id.noTest);
            scoreTest = itemView.findViewById(R.id.testFoiz);
            progressBar = itemView.findViewById(R.id.testProg);


        }


        public void setData(final  int pos, int progress) {
            textNo.setText("Test No :" + String.valueOf(pos + 1));
            scoreTest.setText(String.valueOf(progress) + "%");
            progressBar.setProgress(progress);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DbQuery.g_selected_cat_index=pos;
                    Intent intent=new Intent(itemView.getContext(), StratTestActivity.class);
                    itemView.getContext().startActivity(intent);
                }
            });

        }
    }

}
