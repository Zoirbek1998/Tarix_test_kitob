package com.example.tarix.HistoryActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tarix.R;
import com.github.barteksc.pdfviewer.PDFView;

public class NeinUzbActivity extends AppCompatActivity {
    PDFView NeinPdf9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nein_uzb);

        NeinPdf9=findViewById(R.id.NeinUzb);

        NeinPdf9.useBestQuality(true);
        NeinPdf9.enableSwipe(true);
        NeinPdf9.fitToWidth();
        NeinPdf9.fromAsset("uzb_tarixi_9.pdf").load();
    }
}