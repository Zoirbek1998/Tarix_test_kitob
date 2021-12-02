package com.example.tarix.HistoryActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tarix.R;
import com.github.barteksc.pdfviewer.PDFView;

public class SixReadingActivity extends AppCompatActivity {
PDFView SixPdf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six_reading);

        SixPdf=findViewById(R.id.SixPdf);

        SixPdf.useBestQuality(true);
        SixPdf.enableSwipe(true);
        SixPdf.fitToWidth();
        SixPdf.fromAsset("qadimgi_tarixi_6.pdf").load();

    }
}