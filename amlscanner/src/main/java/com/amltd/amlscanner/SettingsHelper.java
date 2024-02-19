package com.amltd.amlscanner;

import android.os.Bundle;

import com.amltd.amlscanner.settings.KeyboardWedgeMode;
import com.amltd.amlscanner.settings.PresentationMode;
import com.amltd.amlscanner.settings.ScannerSettings;

class SettingsHelper {
    public static ScannerSettings parseScannerSettings(Bundle bundle)
    {
        if (bundle == null)
            return new ScannerSettings();
        else
        {
            ScannerSettings scannerSettings = new ScannerSettings();
            ScannerBundle scannerBundle = new ScannerBundle(bundle);
            String prefix = scannerBundle.getPrefix();
            if (prefix != null)
                scannerSettings.setPrefix(prefix);
            String suffix = scannerBundle.getSuffix();
            if (suffix != null)
                scannerSettings.setSuffix(suffix);
            String sound = scannerBundle.getSound();
            if (sound != null)
                scannerSettings.setScanSound(sound);
            int kwMode = scannerBundle.getKeyboardWedgeMode();
            if (kwMode != -1)
            {
                KeyboardWedgeMode wMode = parseKeyboardWedgeMode(kwMode);
                if (wMode != null)
                    scannerSettings.setKeyboardWedgeMode(wMode);
            }
            scannerSettings.setScannerEnabled(scannerBundle.getScannerEnabled());
            scannerSettings.setBarcodeActionsEnabled(scannerBundle.getBarcodeActionsEnable());
            scannerSettings.setContinuousScanEnabled(scannerBundle.getContScanMode());
            scannerSettings.setLEDFlashOnScanEnabled(scannerBundle.getLEDFlashScanMode());
            scannerSettings.setScanKeyEventModeEnabled(scannerBundle.getScanKeyEventMode());
            scannerSettings.setManagedModeEnabled(scannerBundle.getManagedEnabled());
            scannerSettings.setHideKeyboardOnScanEnabled(parseHideKeyboardOnScan(scannerBundle.getHideKeyboard()));
            scannerSettings.setPresentationMode(parsePresentationMode(scannerBundle.getPresentationMode()));
            scannerSettings.setKeyboardWedgeEnabled(parseKeyboardWedgeEnabled(scannerBundle.getScannerModeFlags()));
            scannerSettings.setAimIdEnabled(parseAimIdEnabled(scannerBundle.getBarcodeFormatFlags()));
            scannerSettings.setPicklistModeEnabled(parsePicklistModeEnabled(scannerBundle.getOpFlags()));
            return scannerSettings;
        }
    }

    public static Boolean parseAimIdEnabled(Long flag) {
        if (flag == null)
            return null;
        else return flag == ScannerProperties.FLAG_BARCODE_FORMAT_AIM_ID;
    }

    public static Long parseAimIdEnabled(Boolean flag){
        long flags = 0;
        if (flag)
            flags |= ScannerProperties.FLAG_BARCODE_FORMAT_AIM_ID;
        else flags &= ~ScannerProperties.FLAG_BARCODE_FORMAT_AIM_ID;
        return flags;
    }

    public static Boolean parsePicklistModeEnabled(Long flag) {
        if (flag == null)
            return null;
        else return flag == ScannerProperties.FLAG_SCANNER_OP_PICK;
    }

    public static Long parsePicklistModeEnabled(Boolean flag){
        long flags = 0;
        if (flag)
            flags |= ScannerProperties.FLAG_SCANNER_OP_PICK;
        else flags &= ~ScannerProperties.FLAG_SCANNER_OP_PICK;
        return flags;
    }

    public static Boolean parseKeyboardWedgeEnabled(Long flag)
    {
        if (flag == null)
            return null;
        else if (flag == ScannerProperties.FLAG_SCANNER_MODE_KEYBOARD_WEDGE)
            return true;
        else return flag != ScannerProperties.FLAG_SCANNER_MODE_INTENT;
    }

    public static Long parseKeyboardWedgeEnabled(Boolean flag){
        long flags = 0;
        if (flag)
            flags = ScannerProperties.FLAG_SCANNER_MODE_KEYBOARD_WEDGE;
        else
            flags = ScannerProperties.FLAG_SCANNER_MODE_INTENT;
        return flags;
    }

    public static PresentationMode parsePresentationMode(Long flag)
    {
        if (flag == null)
            return null;
        else if (flag == ScannerProperties.FLAG_SCANNER_OP_MANUAL_TRIGGER)
            return PresentationMode.MANUALTRIGGER;
        else if (flag == ScannerProperties.FLAG_SCANNER_OP_NORMAL_PRESENTATION)
            return PresentationMode.NORMALPRESENTATION;
        else if (flag == ScannerProperties.FLAG_SCANNER_OP_MOBILE_PRESENTATION)
            return PresentationMode.MOBILEPRESENTATION;
        else if (flag == ScannerProperties.FLAG_SCANNER_OP_STREAMING_PRESENTATION)
            return PresentationMode.STREAMINGPRESENTATION;
        else
            return null;
    }

    public static Boolean parseHideKeyboardOnScan(Long flag){
        if (flag == null)
            return null;
        else return flag == ScannerProperties.FLAG_HIDE_IME_ON_SCAN;
    }

    public static Long parseHideKeyboardOnScan(Boolean flag){
        long flags = 0;
        if (flag)
            flags |= ScannerProperties.FLAG_HIDE_IME_ON_SCAN;
        else flags &= ~ScannerProperties.FLAG_HIDE_IME_ON_SCAN;
        return flags;
    }

    public static KeyboardWedgeMode parseKeyboardWedgeMode(int mode){
        if (mode == 0)
            return KeyboardWedgeMode.FASTINPUT;
        else if (mode == 1)
            return KeyboardWedgeMode.TRUEKEYPRESS;
        else
            return null;
    }

    public static Bundle parseSettingsBundle(ScannerSettings settings)
    {
        ScannerBundle scannerBundle = new ScannerBundle();
        if (settings.getPrefix() != null)
            scannerBundle.setPrefix(settings.getPrefix());
        if (settings.getSuffix() != null)
            scannerBundle.setSuffix(settings.getSuffix());
        if (settings.getScanSound() != null)
            scannerBundle.setSound(settings.getScanSound());
        if (settings.getKeyboardWedgeMode() != null)
            scannerBundle.setKeyboardWedgeMode(settings.getKeyboardWedgeMode().getValue());
        if (settings.isScannerEnabled() != null)
            scannerBundle.setScannerEnabled(settings.isScannerEnabled());
        if (settings.isBarcodeActionsEnabled() != null)
            scannerBundle.setBarcodeActionsEnable(settings.isBarcodeActionsEnabled());
        if (settings.isContinuousScanEnabled() != null)
            scannerBundle.setContScanMode(settings.isContinuousScanEnabled());
        if (settings.isLEDFlashOnScanEnabled() != null)
            scannerBundle.setLEDFlashScanMode(settings.isLEDFlashOnScanEnabled());
        if (settings.isScanKeyEventModeEnabled() != null)
            scannerBundle.setScanKeyEventMode(settings.isScanKeyEventModeEnabled());
        if (settings.isManagedModeEnabled() != null)
            scannerBundle.setManagedEnabled(settings.isManagedModeEnabled());
        if (settings.isHideKeyboardOnScanEnabled() != null)
            scannerBundle.setHideKeyboard(parseHideKeyboardOnScan(settings.isHideKeyboardOnScanEnabled()));
        if (settings.getPresentationMode() != null)
            scannerBundle.setPresentationMode(settings.getPresentationMode().getValue());
        if (settings.isKeyboardWedgeEnabled() != null)
            scannerBundle.setScannerModeFlags(parseKeyboardWedgeEnabled(settings.isKeyboardWedgeEnabled()));
        if (settings.isAimIdEnabled() != null)
            scannerBundle.setBarcodeFormatFlags(parseAimIdEnabled(settings.isAimIdEnabled()));
        if (settings.isPicklistModeEnabled() != null)
            scannerBundle.setOpFlags(parsePicklistModeEnabled(settings.isPicklistModeEnabled()));
        return scannerBundle.getBundle();
    }
}
