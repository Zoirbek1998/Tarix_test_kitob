package com.example.tarix.HistoryActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tarix.R;
import com.github.barteksc.pdfviewer.PDFView;

public class ReadingActivity extends AppCompatActivity {
    private PDFView pdfView;
    ImageView BtnImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);

        pdfView=findViewById(R.id.pdfView);
        BtnImage=findViewById(R.id.btnImage);

        pdfView.useBestQuality(true);
        pdfView.enableSwipe(true);
        pdfView.fitToWidth();
        pdfView.fromAsset("tarixdan_hikoyalar_5_uzb.pdf").load();

        BtnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            ReadingActivity.super.onBackPressed();
            }
        });


    }
}