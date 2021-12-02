package com.example.tarix.HistoryActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tarix.R;
import com.github.barteksc.pdfviewer.PDFView;

public class NeinJahonActivity extends AppCompatActivity {
    PDFView NeinPdf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nein_jahon);

    NeinPdf=findViewById(R.id.PdfJahon);

        NeinPdf.useBestQuality(true);
        NeinPdf.enableSwipe(true);
        NeinPdf.fitToWidth();
        NeinPdf.fromAsset("jahon_tarixi_9_uzb.pdf").load();


    }
}