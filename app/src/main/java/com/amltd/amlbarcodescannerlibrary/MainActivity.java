package com.amltd.amlbarcodescannerlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.amltd.amlscanner.AMLBarcodeScanner;
import com.amltd.amlscanner.AMLDevice;
import com.amltd.amlscanner.OnBTScannerConnected;
import com.amltd.amlscanner.OnBTScannerDisconnected;
import com.amltd.amlscanner.OnBTScannerLowBattery;
import com.amltd.amlscanner.OnErrorListener;
import com.amltd.amlscanner.OnReceiveBTDeviceInfo;
import com.amltd.amlscanner.OnReceiveSettings;
import com.amltd.amlscanner.OnScannedListener;
import com.amltd.amlscanner.OnTriggerPulledListener;
import com.amltd.amlscanner.OnTriggerReleasedListener;
import com.amltd.amlscanner.btscanner.BTDeviceInfo;
import com.amltd.amlscanner.btscanner.BTScanDevice;
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
                String suffix = settings.getSuffix();
                if (suffix == null || !suffix.equals("!"))
                {
                    //Set suffix
                    settings.setSuffix("!");
                    amlScanner.changeSettings(settings);
                }
            }
        });
        amlScanner.disableKeyboardWedge();
    }
    BTDeviceInfo storedBTScanner;
    public void getCurrentBTDevice()
    {
        if (AMLDevice.isBTScannerSupported(getApplicationContext()))
        {
            amlScanner.getBTScannerInfo(new OnReceiveBTDeviceInfo() {
                @Override
                public void onReceive(BTDeviceInfo btDevice) {
                    /*BTDeviceInfo will never be null. If there is not a bt scanner stored for the device, all properties
                    of BTDeviceInfo will be empty strings.*/
                    String btName = btDevice.getBTName();
                    if (btName != null && !btName.equals(""))
                    {
                        storedBTScanner = btDevice;
                        registerBTScannerEvents();
                    }
                }
            });
        }
    }

    public void registerBTScannerEvents()
    {
        amlScanner.setOnBTScannerConnected(new OnBTScannerConnected() {
            @Override
            public void onBTScannerConnected(BTScanDevice btDevice) {
                //Implement handling
            }
        });

        amlScanner.setOnBTScannerDisconnected(new OnBTScannerDisconnected() {
            @Override
            public void onBTScannerDisconnected(BTScanDevice btDevice) {
                //Implement handling
            }
        });

        amlScanner.setOnBTScannerLowBattery(new OnBTScannerLowBattery() {
            @Override
            public void onBTScannerLowBattery(int battery) {
                //Implement handling
            }
        });
    }
}