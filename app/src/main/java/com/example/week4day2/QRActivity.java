package com.example.week4day2;

import static android.app.PendingIntent.getActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.budiyev.android.codescanner.ScanMode;
import com.google.zxing.Result;

public class QRActivity extends AppCompatActivity {
    CodeScanner scanner;
    CodeScannerView scannerView;
    public static TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qractivity);

        scannerView = (CodeScannerView) findViewById(R.id.scanner);
        textView = (TextView) findViewById(R.id.textview);
        startScanner();

        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanner.startPreview();
            }
        });
    }

    public void startScanner() {
        scanner = new CodeScanner(this, scannerView);
        scanner.setFormats(CodeScanner.ALL_FORMATS);
        scanner.setScanMode(ScanMode.CONTINUOUS);

        scanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(result.getText());
                    }
                });
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        scanner.releaseResources();
    }

    @Override
    protected void onResume() {
        super.onResume();
        scanner.startPreview();
    }
}