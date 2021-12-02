package com.example.tarix.HistoryActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tarix.R;
import com.github.barteksc.pdfviewer.PDFView;

public class ElevinJahonActivity extends AppCompatActivity {
    PDFView Pdfbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elevin_jahon);

        Pdfbtn=findViewById(R.id.ElevenBtn);
        Pdfbtn.useBestQuality(true);
        Pdfbtn.enableSwipe(true);
        Pdfbtn.fitToWidth();
        Pdfbtn.fromAsset("jahon_tarixi_11.pdf").load();
    }
}