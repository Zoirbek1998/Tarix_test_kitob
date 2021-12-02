package com.example.tarix.HistoryActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tarix.R;
import com.github.barteksc.pdfviewer.PDFView;

public class EightReadingActivity extends AppCompatActivity {
    PDFView EightImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight_reading);

        EightImage = findViewById(R.id.eightImage);

        EightImage.useBestQuality(true);
        EightImage.enableSwipe(true);
        EightImage.fitToWidth();
        EightImage.fromAsset("jahon_tarixi_8_uzb.pdf").load();

    }
}