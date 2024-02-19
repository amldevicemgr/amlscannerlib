package com.amltd.amlbarcodescannerlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.amltd.amlscanner.AMLBarcodeScanner;
import com.amltd.amlscanner.OnErrorListener;
import com.amltd.amlscanner.OnReceiveSettings;
import com.amltd.amlscanner.OnScannedListener;
import com.amltd.amlscanner.OnTriggerPulledListener;
import com.amltd.amlscanner.OnTriggerReleasedListener;
import com.amltd.amlscanner.settings.ScannerSettings;

public class MainActivity extends AppCompatActivity {

    public AMLBarcodeScanner amlScanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            amlScanner = new AMLBarcodeScanner(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        amlScanner.open();
        amlScanner.setOnErrorListener(new OnErrorListener() {
            @Override
            public void onError(Exception e) {
            }
        });
        amlScanner.setOnTriggerPulledListener(new OnTriggerPulledListener() {
            @Override
            public void onTriggerPulled() {
            }
        });
        amlScanner.setOnTriggerReleasedListener(new OnTriggerReleasedListener() {
            @Override
            public void onTriggerReleased() {
            }
        });
        amlScanner.setOnScannedListener(new OnScannedListener() {
            @Override
            public void onScanned(String barcode, String rawBarcode) {
            }
        });
        amlScanner.getScannerSettings(new OnReceiveSettings() {
            @Override
            public void onReceive(ScannerSettings settings) {

            }
        });
        amlScanner.disableKeyboardWedge();
    }
}