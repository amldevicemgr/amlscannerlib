package com.amltd.amlscanner;

import android.os.Bundle;

class ScannerBundle {
    protected Bundle mBundle;
    public Bundle getBundle() { return mBundle; }

    public ScannerBundle() {
        mBundle = new Bundle();
    }
    public ScannerBundle(Bundle bundle) {
        mBundle = bundle;
    }

    /* Get methods */

    // Use nullable Integer, Long, Boolean types so we get "null" back when there is no mapping.
    // (Instead of value types "0" or "false" for no mapping when using "getInt" etc.)
    // Null is treated like the "not set" value.

    public String getPrefix() { return mBundle.getString(ScannerProperties.PROPERTY_NAME_PREFIX); }
    public String getSuffix() {
        return mBundle.getString(ScannerProperties.PROPERTY_NAME_SUFFIX);
    }
    public String getSound() { return  mBundle.getString(ScannerProperties.PROPERTY_NAME_SOUND); }
    public Integer getKeyboardWedgeMode() { return (Integer)mBundle.get(ScannerProperties.PROPERTY_NAME_KEYBOARD_WEDGE_MODE); }
    public Boolean getScannerEnabled() { return (Boolean)mBundle.get(ScannerProperties.PROPERTY_NAME_SCANNER_ENABLED); }
    public Boolean getBarcodeActionsEnable(){ return (Boolean)mBundle.get(ScannerProperties.PROPERTY_BARCODE_ACTIONS_ENABLE); }
    public Boolean getContScanMode() { return (Boolean)mBundle.get(ScannerProperties.PROPERTY_NAME_CONT_SCAN_MODE); }
    public Boolean getLEDFlashScanMode() { return (Boolean)mBundle.get(ScannerProperties.PROPERTY_NAME_LED_FLASH_SCAN); }
    public Boolean getScanKeyEventMode() { return (Boolean) mBundle.get(ScannerProperties.PROPERTY_NAME_SCAN_KEY_EVENT); }
    public Boolean getManagedEnabled() { return (Boolean)mBundle.get(ScannerProperties.PROPERTY_NAME_MANAGED_ENABLED); }
    public Long getHideKeyboard() { return (Long)mBundle.get(ScannerProperties.PROPERTY_NAME_FLAGS); }
    public Long getPresentationMode() { return (Long)mBundle.get(ScannerProperties.PROPERTY_NAME_PRESENTATION_FLAGS); }
    public Long getScannerModeFlags() { return (Long)mBundle.get(ScannerProperties.PROPERTY_NAME_SCANNER_MODE_FLAGS); }
    public Long getBarcodeFormatFlags() { return (Long)mBundle.get(ScannerProperties.PROPERTY_NAME_BARCODE_FORMAT_FLAGS); }
    public Long getOpFlags() { return (Long)mBundle.get(ScannerProperties.PROPERTY_NAME_SCANNER_OP_FLAGS); }

    /* Set methods */

    public ScannerBundle setPrefix(String prefix) {
        if (prefix != null) mBundle.putString(ScannerProperties.PROPERTY_NAME_PREFIX, prefix);
        return this;
    }
    public ScannerBundle setSound(String soundUrl) {
        if (soundUrl != null) mBundle.putString(ScannerProperties.PROPERTY_NAME_SOUND, soundUrl);
        return this;
    }
    public ScannerBundle setSuffix(String suffix) {
        if (suffix != null) mBundle.putString(ScannerProperties.PROPERTY_NAME_SUFFIX, suffix);
        return this;
    }
    public ScannerBundle setKeyboardWedgeMode(int wedge) {
        mBundle.putInt(ScannerProperties.PROPERTY_NAME_KEYBOARD_WEDGE_MODE, wedge);
        return this;
    }
    public ScannerBundle setScannerEnabled(boolean enabled) {
        mBundle.putBoolean(ScannerProperties.PROPERTY_NAME_SCANNER_ENABLED, enabled);
        return this;
    }
    public ScannerBundle setBarcodeActionsEnable(boolean enabled){
        mBundle.putBoolean(ScannerProperties.PROPERTY_BARCODE_ACTIONS_ENABLE, enabled);
        return this;
    }
    public ScannerBundle setContScanMode(boolean enabled){
        mBundle.putBoolean(ScannerProperties.PROPERTY_NAME_CONT_SCAN_MODE, enabled);
        return this;
    }
    public ScannerBundle setLEDFlashScanMode(boolean enabled){
        mBundle.putBoolean(ScannerProperties.PROPERTY_NAME_LED_FLASH_SCAN, enabled);
        return this;
    }
    public ScannerBundle setScanKeyEventMode(boolean enabled){
        mBundle.putBoolean(ScannerProperties.PROPERTY_NAME_SCAN_KEY_EVENT, enabled);
        return this;
    }
    public ScannerBundle setManagedEnabled(boolean enabled) {
        mBundle.putBoolean(ScannerProperties.PROPERTY_NAME_MANAGED_ENABLED, enabled);
        return this;
    }
    public ScannerBundle setHideKeyboard(long flags) {
        mBundle.putLong(ScannerProperties.PROPERTY_NAME_FLAGS, flags);
        return this;
    }
    public ScannerBundle setPresentationMode(long flags) {
        mBundle.putLong(ScannerProperties.PROPERTY_NAME_PRESENTATION_FLAGS, flags);
        return this;
    }
    public ScannerBundle setScannerModeFlags(long flags) {
        mBundle.putLong(ScannerProperties.PROPERTY_NAME_SCANNER_MODE_FLAGS, flags);
        return this;
    }
    public ScannerBundle setBarcodeFormatFlags(long flags) {
        mBundle.putLong(ScannerProperties.PROPERTY_NAME_BARCODE_FORMAT_FLAGS, flags);
        return this;
    }

    public ScannerBundle setOpFlags(long flags) {
        mBundle.putLong(ScannerProperties.PROPERTY_NAME_SCANNER_OP_FLAGS, flags);
        return this;
    }
}
