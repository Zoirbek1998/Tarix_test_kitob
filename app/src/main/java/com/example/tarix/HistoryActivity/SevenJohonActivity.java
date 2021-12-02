package com.example.tarix.HistoryActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tarix.R;
import com.github.barteksc.pdfviewer.PDFView;

public class SevenJohonActivity extends AppCompatActivity {
    PDFView JahonPdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven_johon);

        JahonPdf = findViewById(R.id.JahonPdf);


        JahonPdf.useBestQuality(true);
        JahonPdf.enableSwipe(true);
        JahonPdf.fitToWidth();
        JahonPdf.fromAsset("jahon_tarixi_7_uzb.pdf").load();

    }
}