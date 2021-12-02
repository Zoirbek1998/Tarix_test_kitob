package com.example.tarix.HistoryActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tarix.R;
import com.github.barteksc.pdfviewer.PDFView;

public class ElevinUzbActivity extends AppCompatActivity {
    PDFView pdfbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_elevin_uzb);

        pdfbtn=findViewById(R.id.ElevenBtn1);

        pdfbtn.useBestQuality(true);
        pdfbtn.enableSwipe(true);
        pdfbtn.fitToWidth();
        pdfbtn.fromAsset("uzb_tarixi_11.pdf").load();
    }
}