package com.example.tarix.HistoryActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tarix.R;
import com.github.barteksc.pdfviewer.PDFView;

public class SevenUzbActivity extends AppCompatActivity {

    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven_uzb);

        pdfView=findViewById(R.id.Uzbpdf);


       pdfView.useBestQuality(true);
       pdfView.enableSwipe(true);
       pdfView.fitToWidth();
       pdfView.fromAsset("ozbekiston_tarixi_7_uzb.pdf").load();


    }

}