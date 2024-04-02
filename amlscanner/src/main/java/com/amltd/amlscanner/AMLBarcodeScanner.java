package com.amltd.amlscanner;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.util.Log;

import com.amltd.amlscanner.btscanner.BTDeviceInfo;
import com.amltd.amlscanner.btscanner.BTScanDevice;
import com.amltd.amlscanner.settings.KeyboardWedgeMode;
import com.amltd.amlscanner.settings.PresentationMode;
import com.amltd.amlscanner.settings.ScannerSettings;
import com.google.gson.Gson;

public class AMLBarcodeScanner {

    /**
     * Opens the AMLBarcodeScanner connection.
     */
    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    public void open() {
        if (mReceiver != null) return;

        //The receiver must be registered with an intent filter.
        // Using an intent filter with the scanned action will tell Android to
        // send intents with the scanned action to this receiver.
        IntentFilter filter = new IntentFilter();
        //Add this if we want an intent with the barcode returned to us after a successful scan.
        filter.addAction(Values.ACTION_SCANNED);
        //Add this if we want an intent with error messages returned to us.
        filter.addAction(Values.ACTION_ERROR);
        //Add this if we want an intent returned to us when the trigger is pulled.
        // This is only an indication of when the trigger is pulled.
        // It does not mean there was a barcode scanned.
        // The intent holds no data other than the action string.
        filter.addAction(Values.ACTION_TRIGGER_PULLED);
        //Add this if we want an intent returned to us when the trigger is released.
        // This is only an indication of when the trigger is released.
        // It does not mean there was a barcode scanned.
        // The intent holds no data other than the action string.
        filter.addAction(Values.ACTION_TRIGGER_RELEASED);
        //Add this if we want to listen for BT Scanner events
        filter.addAction(Values.ACTION_RING_SCANNER_CONNECTED);
        filter.addAction(Values.ACTION_RING_SCANNER_DISCONNECTED);
        filter.addAction(Values.ACTION_RING_SCANNER_LOW_BATTERY);

        //This broadcast receiver will handle incoming intents from the scanner service.
        mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (action != null)
                {
                    switch (action) {
                        case Values.ACTION_SCANNED:
                            String barcode = intent.getStringExtra(Values.EXTRA_DATA);
                            String rawBarcode = intent.getStringExtra(Values.EXTRA_RAW_DATA);
                            if (mOnScannedListener != null)
                                mOnScannedListener.onScanned(barcode, rawBarcode);
                            break;

                        case Values.ACTION_ERROR:
                            String errMsg = intent.getStringExtra(Values.EXTRA_DATA);
                            if (mOnErrorListener != null)
                                mOnErrorListener.onError(new Exception(errMsg));
                            break;

                        case Values.ACTION_TRIGGER_PULLED:
                            if (mOnTriggerPulledListener != null)
                                mOnTriggerPulledListener.onTriggerPulled();
                            break;
                        case Values.ACTION_TRIGGER_RELEASED:
                            if (mOnTriggerReleasedListener != null)
                                mOnTriggerReleasedListener.onTriggerReleased();
                            break;
                        case Values.ACTION_RING_SCANNER_CONNECTED:
                        case Values.ACTION_RING_SCANNER_DISCONNECTED:
                            String btscannerstring = intent.getStringExtra(Values.EXTRA_RING_SCANNER);
                            if (btscannerstring != null && !btscannerstring.equals(""))
                            {
                                BTScanDevice btscanner = new Gson().fromJson(btscannerstring, BTScanDevice.class);
                                if (action.equals(Values.ACTION_RING_SCANNER_CONNECTED))
                                {
                                    if (mOnBTScannerConnected != null)
                                        mOnBTScannerConnected.onBTScannerConnected(btscanner);
                                }
                                else
                                {
                                    if (mOnBTScannerDisconnected != null)
                                        mOnBTScannerDisconnected.onBTScannerDisconnected(btscanner);
                                }
                            }
                            break;
                        case Values.ACTION_RING_SCANNER_LOW_BATTERY:
                            int battery = intent.getIntExtra(Values.EXTRA_RING_SCANNER_LOW_BATTERY, -1);
                            if (mOnBTScannerLowBattery != null)
                                mOnBTScannerLowBattery.onBTScannerLowBattery(battery);
                            break;
                    }
                }
            }
        };

        //Register the broadcast receiver.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            mContext.registerReceiver(mReceiver, filter, Context.RECEIVER_EXPORTED);
        }
        else
        {
            mContext.registerReceiver(mReceiver, filter);
        }
        //Call startService to ensure AML Barcode Service is running.
        startService();
    }

    /**
     * Closes the AMLBarcodeScanner and stops listening for barcode data.
     */
    public void close() {
        if (mReceiver != null) {
            BroadcastReceiver br = mReceiver;
            mReceiver = null;
            //Make sure to unregister when we no longer need to listen to the scanner service.
            mContext.unregisterReceiver(br);
        }
    }

    /**
     * Sets the OnBTScannerConnected to receive notifications when a bt scanner is connected.
     * @param listener The OnBTScannerConnected to listen for bt scanner connection.
     */
    public void setOnBTScannerConnected(OnBTScannerConnected listener) {
        mOnBTScannerConnected = listener;
    }

    /**
     * Sets the OnBTScannerDisconnected to receive notifications when a bt scanner is disconnected.
     * @param listener The OnBTScannerDisconnected to listen for bt scanner disconnection.
     */
    public void setOnBTScannerDisconnected(OnBTScannerDisconnected listener) {
        mOnBTScannerDisconnected = listener;
    }

    /**
     * Sets the OnBTScannerLowBattery to receive notifications when the bt scanner has a low battery.
     * @param listener The OnBTScannerLowBattery to listen for bt scanner low battery events.
     */
    public void setOnBTScannerLowBattery(OnBTScannerLowBattery listener) {
        mOnBTScannerLowBattery = listener;
    }

    /**
     * Sets the OnScannedListener to receive barcode scan data.
     * @param listener The OnScannedListener to listen for barcode data.
     */
    public void setOnScannedListener(OnScannedListener listener) {
        mOnScannedListener = listener;
    }

    /**
     * Sets the OnErrorListener to receive service exceptions.
     * @param listener The OnErrorListener to listen for service exceptions.
     */
    public void setOnErrorListener(OnErrorListener listener) {
        mOnErrorListener = listener;
    }

    /**
     * Sets the OnTriggerPulledListener to receive notifications when the device trigger is pulled.
     * @param listener The OnTriggerPulledListener to listen for trigger pulled notifications.
     */
    public void setOnTriggerPulledListener(OnTriggerPulledListener listener)  {
        mOnTriggerPulledListener = listener;
    }

    /**
     * Sets the OnTriggerReleasedListener to receive notifications when the device trigger is released.
     * @param listener The OnTriggerReleasedListener to listen for trigger release notifications.
     */
    public void setOnTriggerReleasedListener(OnTriggerReleasedListener listener)  {
        mOnTriggerReleasedListener = listener;
    }

    /**
     * Constructs an AMLBarcodeScanner instance to configure the barcode scanner and receive barcode data.
     * @param context The context of the application.
     * @throws Exception Throws Exception if context is null.
     */
    public AMLBarcodeScanner(Context context) throws Exception {
        if (context == null)
            throw new Exception("AMLBarcodeScanner - Context cannot be null.");
        mContext = context;
    }

    /**
     * Sets the scan sound from a notification ringtone.
     * @param sound The name of the ringtone from notification settings.
     */
    public void setScanSound(String sound) {
        if (sound == null)
            sound = "";
        ScannerBundle scannerSettings = new ScannerBundle();
        scannerSettings.setSound(sound);
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Sets the scanner presentation mode.
     * @param mode The scanner presentation mode to set.
     */
    public void setPresentationMode(PresentationMode mode) {
        if (mode == null)
            mode = PresentationMode.MANUALTRIGGER;
        ScannerBundle scannerSettings = new ScannerBundle();
        long flags = 0;
        flags = mode.getValue();
        scannerSettings.setPresentationMode(flags);
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Disables scanner presentation mode.
     */
    public void disablePresentationMode() {
        ScannerBundle scannerSettings = new ScannerBundle();
        long flags = 0;
        flags = PresentationMode.MANUALTRIGGER.getValue();
        scannerSettings.setPresentationMode(flags);
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Enables AIM ID.
     */
    public void enableAimId() {
        long flags = 0;
        ScannerBundle scannerSettings = new ScannerBundle();
        flags |= ScannerProperties.FLAG_BARCODE_FORMAT_AIM_ID;
        scannerSettings.setBarcodeFormatFlags(flags);
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Disables AIM ID.
     */
    public void disableAimId() {
        long flags = 0;
        ScannerBundle scannerSettings = new ScannerBundle();
        flags &= ~ScannerProperties.FLAG_BARCODE_FORMAT_AIM_ID;
        scannerSettings.setBarcodeFormatFlags(flags);
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Enables picklist mode.
     */
    public void enablePicklistMode() {
        long flags = 0;
        ScannerBundle scannerSettings = new ScannerBundle();
        flags |= ScannerProperties.FLAG_SCANNER_OP_PICK;
        scannerSettings.setOpFlags(flags);
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Disables picklist mode.
     */
    public void disablePicklistMode() {
        long flags = 0;
        ScannerBundle scannerSettings = new ScannerBundle();
        flags &= ~ScannerProperties.FLAG_SCANNER_OP_PICK;
        scannerSettings.setOpFlags(flags);
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Enables the keyboard wedge.
     */
    public void enableKeyboardWedge() {
        long flags = ScannerProperties.FLAG_SCANNER_MODE_KEYBOARD_WEDGE;
        ScannerBundle scannerSettings = new ScannerBundle();
        scannerSettings.setScannerModeFlags(flags);
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Disables the keyboard wedge.
     */
    public void disableKeyboardWedge() {
        long flags = ScannerProperties.FLAG_SCANNER_MODE_INTENT;
        ScannerBundle scannerSettings = new ScannerBundle();
        scannerSettings.setScannerModeFlags(flags);
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Enables managed mode.
     */
    public void enableManagedMode() {
        ScannerBundle scannerSettings = new ScannerBundle();
        scannerSettings.setManagedEnabled(true);
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Disables managed mode.
     */
    public void disableManagedMode() {
        ScannerBundle scannerSettings = new ScannerBundle();
        scannerSettings.setManagedEnabled(false);
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Enables scan key event mode.
     */
    public void enableScanKeyEventMode() {
        ScannerBundle scannerSettings = new ScannerBundle();
        scannerSettings.setScanKeyEventMode(true);
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Disables scan key event mode.
     */
    public void disableScanKeyEventMode() {
        ScannerBundle scannerSettings = new ScannerBundle();
        scannerSettings.setScanKeyEventMode(false);
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Enables hide keyboard on scan.
     */
    public void enableHideKeyboardOnScan() {
        ScannerBundle scannerSettings = new ScannerBundle();
        long flags = 0;
        //enable hide keyboard on scan
        flags |= ScannerProperties.FLAG_HIDE_IME_ON_SCAN;

        scannerSettings.setHideKeyboard(flags);
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Disables hide keyboard on scan.
     */
    public void disableHideKeyboardOnScan() {
        ScannerBundle scannerSettings = new ScannerBundle();
        long flags = 0;

        //disable hide keyboard on scan
        flags &= ~ScannerProperties.FLAG_HIDE_IME_ON_SCAN;
        scannerSettings.setHideKeyboard(flags);
        changeSettings(scannerSettings.getBundle());
    }


    /**
     * Enables LED flash on scan.
     */
    public void enableLEDFlashOnScan() {
        ScannerBundle scannerSettings = new ScannerBundle();
        scannerSettings.setLEDFlashScanMode(true);
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Disables LED flash on scan.
     */
    public void disableLEDFlashOnScan() {
        ScannerBundle scannerSettings = new ScannerBundle();
        scannerSettings.setLEDFlashScanMode(false);
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Enables continuous scan mode.
     */
    public void enableContinuousScan() {
        ScannerBundle scannerSettings = new ScannerBundle();
        scannerSettings.setContScanMode(true);
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Disables continuous scan mode.
     */
    public void disableContinuousScan() {
        ScannerBundle scannerSettings = new ScannerBundle();
        scannerSettings.setContScanMode(false);
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Enables barcode smart actions.
     */
    public void enableBarcodeActions() {
        ScannerBundle scannerSettings = new ScannerBundle();
        scannerSettings.setBarcodeActionsEnable(true);
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Disables barcode smart actions.
     */
    public void disableBarcodeActions() {
        ScannerBundle scannerSettings = new ScannerBundle();
        scannerSettings.setBarcodeActionsEnable(false);
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Enables the scanner.
     */
    public void enableScanner() {
        ScannerBundle scannerSettings = new ScannerBundle();
        scannerSettings.setScannerEnabled(true);
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Disables the scanner.
     */
    public void disableScanner() {
        ScannerBundle scannerSettings = new ScannerBundle();
        scannerSettings.setScannerEnabled(false);
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Sets the keyboard wedge mode.
     * @param mode The keyboard wedge mode.
     */
    public void setKeyboardWedgeMode(KeyboardWedgeMode mode) {
        if (mode == null)
            mode = KeyboardWedgeMode.TRUEKEYPRESS;
        ScannerBundle scannerSettings = new ScannerBundle();
        scannerSettings.setKeyboardWedgeMode(mode.getValue());
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Set the prefix for the barcode scanner.
     * @param prefix The prefix value for the barcode scanner.
     */
    public void setPrefix(String prefix) {
        if (prefix == null)
            prefix = "";
        ScannerBundle scannerSettings = new ScannerBundle();
        scannerSettings.setPrefix(prefix);
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Set the suffix for the barcode scanner.
     * For non-printable ASCII characters, use the following format:
     * "\\NN" - where NN is the double digit hex number representation of the character,
     * and backslash is the required escape/indicator character (double to escape backslash in string).
     * @param suffix The suffix value for the barcode scanner.
     */
    public void setSuffix(String suffix) {
        if (suffix == null)
            suffix = "";
        ScannerBundle scannerSettings = new ScannerBundle();
        scannerSettings.setSuffix(suffix);
        changeSettings(scannerSettings.getBundle());
    }

    /**
     * Send a correctly setup ScannerSettings config to the scanner service to be processed in order to
     * change the scanner behavior.
     * @param settings The scanner settings generated with ScannerSettings.
     */
    public void changeSettings(ScannerSettings settings) {

        if (settings != null)
        {
            Bundle bundle = SettingsHelper.parseSettingsBundle(settings);
            Intent intent = new Intent();
            intent.putExtras(bundle);

            //Calling startService and passing in our intent is how we send the intent to the
            //scanner service for processing.
            startService(intent);
        }
    }

    /**
     * Request the current bt scanner info asynchronously.
     * @param receiver The OnReceiveBTDeviceInfo listener to receive the bt scanner info.
     */
    public void getBTScannerInfo(OnReceiveBTDeviceInfo receiver) {
        if (receiver != null)
        {
            Bundle bundle = new Bundle();
            ResultReceiver resultReceiver = new ResultReceiver(new Handler()) {
                @Override
                protected void onReceiveResult(int resultCode, Bundle resultData) {
                    String btscannerstring = resultData.getString(Values.EXTRA_BT_DEVICE_INFO);
                    BTDeviceInfo btscanner = new Gson().fromJson(btscannerstring, BTDeviceInfo.class);
                    receiver.onReceive(btscanner);
                }
            };
            //If you change the package name of this file use this before adding to the bundle
            if (!"com.amltd.barcodelib.sdk.BarcodeScanner".equals(getClass().getCanonicalName())) {
                Parcel p = Parcel.obtain();
                resultReceiver.writeToParcel(p, 0);
                p.setDataPosition(0);
                resultReceiver = ResultReceiver.CREATOR.createFromParcel(p);
                p.recycle();
            }
            bundle.putParcelable(Intent.EXTRA_RESULT_RECEIVER, resultReceiver);
            Intent intent = new Intent();
            intent.setAction(Values.GET_BT_DEVICE_INFO_ACTION);
            intent.putExtras(bundle);
            intent.setClassName(Values.PACKAGE_NAME, Values.CLASS_NAME);
            //Calling startService and passing in our intent is how we send the intent to the
            //scanner service for processing.
            mContext.sendBroadcast(intent);
        }
    }

    /**
     * Request the current scanner settings asynchronously.
     * @param receiver The OnReceiveSettings listener to receive the scanner settings.
     */
    public void getScannerSettings(OnReceiveSettings receiver) {
        if (receiver != null)
        {
            Bundle bundle = new Bundle();
            ResultReceiver resultReceiver = new ResultReceiver(new Handler()) {
                @Override
                protected void onReceiveResult(int resultCode, Bundle resultData) {
                    Log.d("AMLSCANNERLIBRARY", "AMLSCANNERLIBRARY received settings");
                    receiver.onReceive(SettingsHelper.parseScannerSettings(resultData));
                }
            };
            //If you change the package name of this file use this before adding to the bundle
            if (!"com.amltd.barcodelib.sdk.BarcodeScanner".equals(getClass().getCanonicalName())) {
                Parcel p = Parcel.obtain();
                resultReceiver.writeToParcel(p, 0);
                p.setDataPosition(0);
                resultReceiver = ResultReceiver.CREATOR.createFromParcel(p);
                p.recycle();
            }
            bundle.putParcelable(Intent.EXTRA_RESULT_RECEIVER, resultReceiver);
            Intent intent = new Intent();
            intent.putExtras(bundle);

            //Calling startService and passing in our intent is how we send the intent to the
            //scanner service for processing.
            startService(intent);
        }
    }

    /**
     * Programmatically show the virtual keyboard.
     */
    public void showKeyboard() {
        startService(new Intent(Values.ACTION_SHOW_IME));
    }

    /**
     * Programmatically hide the virtual keyboard.
     */
    public void hideKeyboard() {
        startService(new Intent(Values.ACTION_HIDE_IME));
    }

    /**
     * Programmatically pull(on) the scanner trigger, or release(off).
     * @param on - True to pull the trigger, otherwise false.
     */
    public void trigger(boolean on) {
        startService(new Intent(on ? Values.ACTION_KEY_SCAN_DOWN : Values.ACTION_KEY_SCAN_UP));
    }

    //region PRIVATE METHODS

    //Application context
    private final Context mContext;

    //For receiving broadcast intents
    private BroadcastReceiver mReceiver;

    //For incoming bt scanner connected action
    private OnBTScannerConnected mOnBTScannerConnected;

    //For incoming bt scanner disconnected action
    private OnBTScannerDisconnected mOnBTScannerDisconnected;

    //For incoming bt scanner low battery action
    private OnBTScannerLowBattery mOnBTScannerLowBattery;

    //For incoming scanned action
    private OnScannedListener mOnScannedListener;

    //For incoming error action
    private OnErrorListener mOnErrorListener;

    //For incoming trigger pulled action
    private OnTriggerPulledListener mOnTriggerPulledListener;

    //For incoming trigger released action
    private OnTriggerReleasedListener mOnTriggerReleasedListener;

    /**
     * Starts AML Barcode Service.
     */
    private void startService() {
        startService(null);
    }

    /**
     * Starts AML Barcode Service with a intent.
     * @param intent The intent to send to the service.
     */
    private void startService(Intent intent) {
        if (intent == null) intent = new Intent();
        intent.setClassName(Values.PACKAGE_NAME, Values.CLASS_NAME);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mContext.startForegroundService(intent);
        } else {
            mContext.startService(intent);
        }
    }

    /**
     * Send a correctly setup settings bundle to the scanner service to be processed in order to
     * change the scanner behavior.
     * @param settings The scanner settings generated with Bundle.
     */
    private void changeSettings(Bundle settings) {
        Intent intent = new Intent();
        intent.putExtras(settings);

        //Calling startService and passing in our intent is how we send the intent to the
        //scanner service for processing.
        startService(intent);
    }

    //endregion
}
