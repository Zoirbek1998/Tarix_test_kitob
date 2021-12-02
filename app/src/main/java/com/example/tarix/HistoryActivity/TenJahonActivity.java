package com.example.tarix.HistoryActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tarix.R;
import com.github.barteksc.pdfviewer.PDFView;

public class TenJahonActivity extends AppCompatActivity {
PDFView PdfBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten_jahon);

        PdfBtn=findViewById(R.id.pdfBtn);

        PdfBtn.useBestQuality(true);
        PdfBtn.enableSwipe(true);
        PdfBtn.fitToWidth();
        PdfBtn.fromAsset("jahon_tarixi_10.pdf").load();
    }
}