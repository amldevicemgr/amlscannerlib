package com.amltd.amlscanner.settings;


public class ScannerSettings {
    private String Prefix;
    private String Suffix;
    private String ScanSound;
    private KeyboardWedgeMode KeyboardWedgeMode;
    private Boolean ScannerEnabled;
    private Boolean BarcodeActions;
    private Boolean ContinuousScan;
    private Boolean LEDFlashOnScan;
    private Boolean ScanKeyEventMode;
    private Boolean ManagedEnabled;
    private Boolean HideKeyboardOnScan;
    private PresentationMode PresentationMode;
    private Boolean KeyboardWedge;
    private Boolean AimId;
    private Boolean PicklistMode;

    public String getPrefix() {
        return Prefix;
    }

    public void setPrefix(String prefix) {
        if (prefix == null)
            prefix = "";
        Prefix = prefix;
    }

    public String getScanSound() {
        return ScanSound;
    }

    public void setScanSound(String sound) {
        if (sound == null)
            sound = "";
        ScanSound = sound;
    }

    public String getSuffix() {
        return Suffix;
    }

    public void setSuffix(String suffix) {
        if (suffix == null)
            suffix = "";
        Suffix = suffix;
    }

    public KeyboardWedgeMode getKeyboardWedgeMode() {
        return KeyboardWedgeMode;
    }

    public void setKeyboardWedgeMode(KeyboardWedgeMode keyboardWedgeMode) {
        KeyboardWedgeMode = keyboardWedgeMode;
    }

    public Boolean isScannerEnabled() {
        return ScannerEnabled;
    }

    public void setScannerEnabled(boolean scannerEnabled) {
        ScannerEnabled = scannerEnabled;
    }

    public Boolean isBarcodeActionsEnabled() {
        return BarcodeActions;
    }

    public void setBarcodeActionsEnabled(boolean barcodeActions) {
        BarcodeActions = barcodeActions;
    }

    public Boolean isContinuousScanEnabled() {
        return ContinuousScan;
    }

    public void setContinuousScanEnabled(boolean continuousScan) {
        ContinuousScan = continuousScan;
    }

    public Boolean isLEDFlashOnScanEnabled() {
        return LEDFlashOnScan;
    }

    public void setLEDFlashOnScanEnabled(boolean LEDFlashOnScan) {
        this.LEDFlashOnScan = LEDFlashOnScan;
    }

    public Boolean isScanKeyEventModeEnabled() {
        return ScanKeyEventMode;
    }

    public void setScanKeyEventModeEnabled(boolean scanKeyEventMode) {
        ScanKeyEventMode = scanKeyEventMode;
    }

    public Boolean isManagedModeEnabled() {
        return ManagedEnabled;
    }

    public void setManagedModeEnabled(boolean managedEnabled) {
        ManagedEnabled = managedEnabled;
    }

    public Boolean isHideKeyboardOnScanEnabled() {
        return HideKeyboardOnScan;
    }

    public void setHideKeyboardOnScanEnabled(boolean hideKeyboardOnScan) {
        HideKeyboardOnScan = hideKeyboardOnScan;
    }

    public PresentationMode getPresentationMode() {
        return PresentationMode;
    }

    public void setPresentationMode(PresentationMode presentationMode) {
        PresentationMode = presentationMode;
    }

    public Boolean isKeyboardWedgeEnabled() {
        return KeyboardWedge;
    }

    public void setKeyboardWedgeEnabled(boolean keyboardWedge) {
        KeyboardWedge = keyboardWedge;
    }

    public Boolean isAimIdEnabled() {
        return AimId;
    }

    public void setAimIdEnabled(boolean aimId) {
        AimId = aimId;
    }

    public Boolean isPicklistModeEnabled() {
        return PicklistMode;
    }

    public void setPicklistModeEnabled(boolean picklistMode) {
        PicklistMode = picklistMode;
    }
}
