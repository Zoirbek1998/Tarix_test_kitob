package com.example.tarix.HistoryActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tarix.R;
import com.github.barteksc.pdfviewer.PDFView;

public class TenUzbActivity extends AppCompatActivity {
    PDFView pdfBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten_uzb);

        pdfBtn=findViewById(R.id.pdfBtn);

        pdfBtn.useBestQuality(true);
        pdfBtn.enableSwipe(true);
        pdfBtn.fitToWidth();
        pdfBtn.fromAsset("uzb_tarixi_10.pdf").load();

    }
}