package com.amltd.amlscanner.settings;

class SymbologyConfig2D {
    private boolean Aztec;
    private boolean CodablockA;
    private boolean CodablockF;
    private boolean DataMatrix;
    private boolean GS1UPCEAN;
    private boolean GS1CompositeCCAB;
    private boolean GS1CompositeCCC;
    private boolean GS1CompositeTLC39;
    private boolean GS1DataMatrix;
    private boolean GS1QRCode;
    private boolean HanXin;
    private boolean MaxiCode;
    private boolean MicroPDF417;
    private boolean MacroPDF417;
    private boolean MicroQRCode;
    private boolean PDF417;
    private boolean QRCode;
    private boolean DotCode;

    /**
     * Sets all 2D symbologies enabled or disabled.
     * @param enabled True to enable all 2D symbologies. False to disable all 2D symbologies.
     */
    public void setAllSymbologiesEnabled(boolean enabled)
    {
        this.Aztec = enabled;
        this.CodablockA = enabled;
        this.CodablockF = enabled;
        this.DotCode = enabled;
        this.DataMatrix = enabled;
        this.GS1CompositeCCAB = enabled;
        this.GS1CompositeCCC = enabled;
        this.GS1CompositeTLC39 = enabled;
        this.GS1UPCEAN = enabled;
        this.GS1DataMatrix = enabled;
        this.GS1QRCode = enabled;
        this.HanXin = enabled;
        this.MacroPDF417 = enabled;
        this.MaxiCode = enabled;
        this.MicroPDF417 = enabled;
        this.MicroQRCode = enabled;
        this.PDF417 = enabled;
        this.QRCode = enabled;
    }


    /**
     * Checks if the Aztec symbology is enabled.
     * @return True if Aztec symbology is enabled. Otherwise, returns false.
     */
    public boolean isAztecEnabled() {
        return Aztec;
    }

    /**
     * Checks if the Codablock A symbology is enabled.
     * @return True if Codablock A symbology is enabled. Otherwise, returns false.
     */
    public boolean isCodablockAEnabled() {
        return CodablockA;
    }

    /**
     * Checks if the Codablock F symbology is enabled.
     * @return True if Codablock F symbology is enabled. Otherwise, returns false.
     */
    public boolean isCodablockFEnabled() {
        return CodablockF;
    }

    /**
     * Checks if the Data Matrix symbology is enabled.
     * @return True if Data Matrix symbology is enabled. Otherwise, returns false.
     */
    public boolean isDataMatrixEnabled() {
        return DataMatrix;
    }

    /**
     * Checks if the GS1 UPC/EAN symbology is enabled.
     * @return True if GS1 UPC/EAN symbology is enabled. Otherwise, returns false.
     */
    public boolean isGS1UPCEANEnabled() {
        return GS1UPCEAN;
    }

    /**
     * Checks if the GS1 Composite CC-AB symbology is enabled.
     * @return True if GS1 Composite CC-AB symbology is enabled. Otherwise, returns false.
     */
    public boolean isGS1CompositeCCABEnabled() {
        return GS1CompositeCCAB;
    }

    /**
     * Checks if the GS1 Composite CC-C symbology is enabled.
     * @return True if GS1 Composite CC-C symbology is enabled. Otherwise, returns false.
     */
    public boolean isGS1CompositeCCCEnabled() {
        return GS1CompositeCCC;
    }

    /**
     * Checks if the GS1 Composite TLC-39 symbology is enabled.
     * @return True if GS1 Composite TLC-39 symbology is enabled. Otherwise, returns false.
     */
    public boolean isGS1CompositeTLC39Enabled() {
        return GS1CompositeTLC39;
    }

    /**
     * Checks if the GS1 Data Matrix symbology is enabled.
     * @return True if GS1 Data Matrix symbology is enabled. Otherwise, returns false.
     */
    public boolean isGS1DataMatrixEnabled() {
        return GS1DataMatrix;
    }

    /**
     * Checks if the GS1 QR Code symbology is enabled.
     * @return True if GS1 QR Code symbology is enabled. Otherwise, returns false.
     */
    public boolean isGS1QRCodeEnabled() {
        return GS1QRCode;
    }

    /**
     * Checks if the Han Xin symbology is enabled.
     * @return True if Han Xin symbology is enabled. Otherwise, returns false.
     */
    public boolean isHanXinEnabled() {
        return HanXin;
    }

    /**
     * Checks if the Maxi Code symbology is enabled.
     * @return True if Maxi Code symbology is enabled. Otherwise, returns false.
     */
    public boolean isMaxiCodeEnabled() {
        return MaxiCode;
    }

    /**
     * Checks if the Micro PDF417 symbology is enabled.
     * @return True if Micro PDF417 symbology is enabled. Otherwise, returns false.
     */
    public boolean isMicroPDF417Enabled() {
        return MicroPDF417;
    }

    /**
     * Checks if the Macro PDF417 symbology is enabled.
     * @return True if Macro PDF417 symbology is enabled. Otherwise, returns false.
     */
    public boolean isMacroPDF417Enabled() {
        return MacroPDF417;
    }

    /**
     * Checks if the Micro QR Code symbology is enabled.
     * @return True if Micro QR Code symbology is enabled. Otherwise, returns false.
     */
    public boolean isMicroQRCodeEnabled() {
        return MicroQRCode;
    }

    /**
     * Checks if the PDF417 symbology is enabled.
     * @return True if PDF417 symbology is enabled. Otherwise, returns false.
     */
    public boolean isPDF417Enabled() {
        return PDF417;
    }

    /**
     * Checks if the QR Code symbology is enabled.
     * @return True if QR Code symbology is enabled. Otherwise, returns false.
     */
    public boolean isQRCodeEnabled() {
        return QRCode;
    }

    /**
     * Checks if the Dot Code symbology is enabled.
     * @return True if Dot Code symbology is enabled. Otherwise, returns false.
     */
    public boolean isDotCodeEnabled() {
        return DotCode;
    }

    /**
     * Sets the Aztec symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setAztecEnabled(boolean enabled) {
        Aztec = enabled;
    }

    /**
     * Sets the Codablock A symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setCodablockAEnabled(boolean enabled) {
        CodablockA = enabled;
    }

    /**
     * Sets the Codablock F symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setCodablockFEnabled(boolean enabled) {
        CodablockF = enabled;
    }

    /**
     * Sets the Data Matrix symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setDataMatrixEnabled(boolean enabled) {
        DataMatrix = enabled;
    }

    /**
     * Sets the GS1 UPC/EAN symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setGS1UPCEANEnabled(boolean enabled) {
        this.GS1UPCEAN = enabled;
    }

    /**
     * Sets the GS1 Composite CC-AB symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setGS1CompositeCCABEnabled(boolean enabled) {
        this.GS1CompositeCCAB = enabled;
    }

    /**
     * Sets the GS1 Composite CC-C symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setGS1CompositeCCCEnabled(boolean enabled) {
        this.GS1CompositeCCC = enabled;
    }

    /**
     * Sets the GS1 Composite TLC-39 symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setGS1CompositeTLC39Enabled(boolean enabled) {
        this.GS1CompositeTLC39 = enabled;
    }

    /**
     * Sets the GS1 Data Matrix symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setGS1DataMatrixEnabled(boolean enabled) {
        this.GS1DataMatrix = enabled;
    }

    /**
     * Sets the GS1 QR Code symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setGS1QRCodeEnabled(boolean enabled) {
        this.GS1QRCode = enabled;
    }

    /**
     * Sets the Han Xin symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setHanXinEnabled(boolean enabled) {
        HanXin = enabled;
    }

    /**
     * Sets the Maxi Code symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setMaxiCodeEnabled(boolean enabled) {
        MaxiCode = enabled;
    }

    /**
     * Sets the Micro PDF417 symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setMicroPDF417Enabled(boolean enabled) {
        MicroPDF417 = enabled;
    }

    /**
     * Sets the Macro PDF417 symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setMacroPDF417Enabled(boolean enabled) {
        MacroPDF417 = enabled;
    }

    /**
     * Sets the Micro QR Code symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setMicroQRCodeEnabled(boolean enabled) {
        MicroQRCode = enabled;
    }

    /**
     * Sets the PDF417 symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setPDF417Enabled(boolean enabled) {
        this.PDF417 = enabled;
    }

    /**
     * Sets the QR Code symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setQRCodeEnabled(boolean enabled) {
        this.QRCode = enabled;
    }

    /**
     * Sets the Dot Code symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setDotCodeEnabled(boolean enabled) {
        DotCode = enabled;
    }
}
