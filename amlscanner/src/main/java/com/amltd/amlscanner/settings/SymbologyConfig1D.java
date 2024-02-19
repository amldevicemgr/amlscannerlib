package com.amltd.amlscanner.settings;

class SymbologyConfig1D {
    private boolean AustralianPost;
    private boolean BooklandEAN;
    private boolean BPO;
    private boolean CanadaPost;
    private boolean Chinese2of5;
    private boolean Codabar;
    private boolean Code11;
    private boolean Code39;
    private boolean Code93;
    private boolean Code128;
    private boolean Discrete2of5;
    private boolean DutchPost;
    private boolean EAN13JAN13;
    private boolean EAN8JAN8;
    private boolean GS1128;
    private boolean GS1DatabarOmni;
    private boolean GS1DatabarLimited;
    private boolean GS1DatabarExpanded;
    private boolean InfoMail;
    private boolean IntelligentMail;
    private boolean Interleaved2of5;
    private boolean ISBT128;
    private boolean ISSNEAN;
    private boolean JapanPost;
    private boolean Korean3of5;
    private boolean Matrix2of5;
    private boolean MSI;
    private boolean Planet;
    private boolean Plessey;
    private boolean Postnet;
    private boolean Standard2of5;
    private boolean SwedenPost;
    private boolean Telepen;
    private boolean UPCA;
    private boolean UPCE;
    private boolean UPCE1;

    /**
     * Sets all 1D symbologies enabled or disabled.
     * @param enabled True to enable all 1D symbologies. False to disable all 1D symbologies.
     */
    public void setAllSymbologiesEnabled(boolean enabled)
    {
        this.AustralianPost = enabled;
        this.BooklandEAN = enabled;
        this.BPO = enabled;
        this.CanadaPost = enabled;
        this.Chinese2of5 = enabled;
        this.Codabar = enabled;
        this.Code11 = enabled;
        this.Code39 = enabled;
        this.Code93 = enabled;
        this.Code128 = enabled;
        this.DutchPost = enabled;
        this.Discrete2of5 = enabled;
        this.EAN8JAN8 = enabled;
        this.EAN13JAN13 = enabled;
        this.GS1DatabarExpanded = enabled;
        this.GS1DatabarLimited = enabled;
        this.GS1DatabarOmni = enabled;
        this.GS1128 = enabled;
        this.ISSNEAN = enabled;
        this.InfoMail = enabled;
        this.ISBT128 = enabled;
        this.IntelligentMail = enabled;
        this.Interleaved2of5 = enabled;
        this.JapanPost = enabled;
        this.Korean3of5 = enabled;
        this.MSI = enabled;
        this.Matrix2of5 = enabled;
        this.Planet = enabled;
        this.Plessey = enabled;
        this.Postnet = enabled;
        this.Standard2of5 = enabled;
        this.SwedenPost = enabled;
        this.Telepen = enabled;
        this.UPCA = enabled;
        this.UPCE = enabled;
        this.UPCE1 = enabled;
    }

    /**
     * Checks if the Australian Post symbology is enabled.
     * @return True if Australian Post symbology is enabled. Otherwise, returns false.
     */
    public boolean isAustralianPostEnabled() {
        return AustralianPost;
    }

    /**
     * Checks if the Bookland EAN symbology is enabled.
     * @return True if Bookland EAN symbology is enabled. Otherwise, returns false.
     */
    public boolean isBooklandEANEnabled() {
        return BooklandEAN;
    }

    /**
     * Checks if the BPO symbology is enabled.
     * @return True if BPO symbology is enabled. Otherwise, returns false.
     */
    public boolean isBPOEnabled() {
        return BPO;
    }

    /**
     * Checks if the Canada Post symbology is enabled.
     * @return True if Canada Post symbology is enabled. Otherwise, returns false.
     */
    public boolean isCanadaPostEnabled() {
        return CanadaPost;
    }

    /**
     * Checks if the Chinese 2 of 5 symbology is enabled.
     * @return True if Chinese 2 of 5 symbology is enabled. Otherwise, returns false.
     */
    public boolean isChinese2of5Enabled() {
        return Chinese2of5;
    }

    /**
     * Checks if the Codabar symbology is enabled.
     * @return True if Codabar symbology is enabled. Otherwise, returns false.
     */
    public boolean isCodabarEnabled() {
        return Codabar;
    }

    /**
     * Checks if the Code 11 symbology is enabled.
     * @return True if Code 11 symbology is enabled. Otherwise, returns false.
     */
    public boolean isCode11Enabled() {
        return Code11;
    }

    /**
     * Checks if the Code 39 symbology is enabled.
     * @return True if Code 39 symbology is enabled. Otherwise, returns false.
     */
    public boolean isCode39Enabled() {
        return Code39;
    }

    /**
     * Checks if the Code 93 symbology is enabled.
     * @return True if Code 93 symbology is enabled. Otherwise, returns false.
     */
    public boolean isCode93Enabled() {
        return Code93;
    }

    /**
     * Checks if the Code 128 symbology is enabled.
     * @return True if Code 128 symbology is enabled. Otherwise, returns false.
     */
    public boolean isCode128Enabled() {
        return Code128;
    }

    /**
     * Checks if the Discrete 2 of 5 symbology is enabled.
     * @return True if Discrete 2 of 5 symbology is enabled. Otherwise, returns false.
     */
    public boolean isDiscrete2of5Enabled() {
        return Discrete2of5;
    }

    /**
     * Checks if the Dutch Post symbology is enabled.
     * @return True if Dutch Post symbology is enabled. Otherwise, returns false.
     */
    public boolean isDutchPostEnabled() {
        return DutchPost;
    }

    /**
     * Checks if the EAN-13 JAN-13 symbology is enabled.
     * @return True if EAN-13 JAN-13 symbology is enabled. Otherwise, returns false.
     */
    public boolean isEAN13JAN13Enabled() {
        return EAN13JAN13;
    }

    /**
     * Checks if the EAN-8 JAN-8 symbology is enabled.
     * @return True if EAN-8 JAN-8 symbology is enabled. Otherwise, returns false.
     */
    public boolean isEAN8JAN8Enabled() {
        return EAN8JAN8;
    }

    /**
     * Checks if the GS1 128 symbology is enabled.
     * @return True if GS1 128 symbology is enabled. Otherwise, returns false.
     */
    public boolean isGS1128Enabled() {
        return GS1128;
    }

    /**
     * Checks if the GS1 Databar (RSS) - Omni symbology is enabled.
     * @return True if GS1 Databar (RSS) - Omni symbology is enabled. Otherwise, returns false.
     */
    public boolean isGS1DatabarOmniEnabled() {
        return GS1DatabarOmni;
    }

    /**
     * Checks if the GS1 Databar (RSS) - Limited symbology is enabled.
     * @return True if GS1 Databar (RSS) - Limited symbology is enabled. Otherwise, returns false.
     */
    public boolean isGS1DatabarLimitedEnabled() {
        return GS1DatabarLimited;
    }

    /**
     * Checks if the GS1 Databar (RSS) - Expanded symbology is enabled.
     * @return True if GS1 Databar (RSS) - Expanded symbology is enabled. Otherwise, returns false.
     */
    public boolean isGS1DatabarExpandedEnabled() {
        return GS1DatabarExpanded;
    }

    /**
     * Checks if the Info Mail symbology is enabled.
     * @return True if Info Mail symbology is enabled. Otherwise, returns false.
     */
    public boolean isInfoMailEnabled() {
        return InfoMail;
    }

    /**
     * Checks if the Intelligent Mail symbology is enabled.
     * @return True if Intelligent Mail symbology is enabled. Otherwise, returns false.
     */
    public boolean isIntelligentMailEnabled() {
        return IntelligentMail;
    }

    /**
     * Checks if the Interleaved 2 of 5 symbology is enabled.
     * @return True if Interleaved 2 of 5 symbology is enabled. Otherwise, returns false.
     */
    public boolean isInterleaved2of5Enabled() {
        return Interleaved2of5;
    }

    /**
     * Checks if the ISBT 128 symbology is enabled.
     * @return True if ISBT 128 symbology is enabled. Otherwise, returns false.
     */
    public boolean isISBT128Enabled() {
        return ISBT128;
    }

    /**
     * Checks if the ISSN EAN symbology is enabled.
     * @return True if ISSN EAN symbology is enabled. Otherwise, returns false.
     */
    public boolean isISSNEANEnabled() {
        return ISSNEAN;
    }

    /**
     * Checks if the Japan Post symbology is enabled.
     * @return True if Japan Post symbology is enabled. Otherwise, returns false.
     */
    public boolean isJapanPostEnabled() {
        return JapanPost;
    }

    /**
     * Checks if the Korean 3 of 5 symbology is enabled.
     * @return True if Korean 3 of 5 symbology is enabled. Otherwise, returns false.
     */
    public boolean isKorean3of5Enabled() {
        return Korean3of5;
    }

    /**
     * Checks if the Matrix 2 of 5 symbology is enabled.
     * @return True if Matrix 2 of 5 symbology is enabled. Otherwise, returns false.
     */
    public boolean isMatrix2of5Enabled() {
        return Matrix2of5;
    }

    /**
     * Checks if the MSI symbology is enabled.
     * @return True if MSI symbology is enabled. Otherwise, returns false.
     */
    public boolean isMSIEnabled() {
        return MSI;
    }

    /**
     * Checks if the Planet symbology is enabled.
     * @return True if Planet symbology is enabled. Otherwise, returns false.
     */
    public boolean isPlanetEnabled() {
        return Planet;
    }

    /**
     * Checks if the Plessey symbology is enabled.
     * @return True if Plessey symbology is enabled. Otherwise, returns false.
     */
    public boolean isPlesseyEnabled() {
        return Plessey;
    }

    /**
     * Checks if the Postnet symbology is enabled.
     * @return True if Postnet symbology is enabled. Otherwise, returns false.
     */
    public boolean isPostnetEnabled() {
        return Postnet;
    }

    /**
     * Checks if the Standard 2 of 5 symbology is enabled.
     * @return True if Standard 2 of 5 symbology is enabled. Otherwise, returns false.
     */
    public boolean isStandard2of5Enabled() {
        return Standard2of5;
    }

    /**
     * Checks if the Sweden Post symbology is enabled.
     * @return True if Sweden Post symbology is enabled. Otherwise, returns false.
     */
    public boolean isSwedenPostEnabled() {
        return SwedenPost;
    }

    /**
     * Checks if the Telepen symbology is enabled.
     * @return True if Telepen symbology is enabled. Otherwise, returns false.
     */
    public boolean isTelepenEnabled() {
        return Telepen;
    }

    /**
     * Checks if the UPC-A symbology is enabled.
     * @return True if UPC-A symbology is enabled. Otherwise, returns false.
     */
    public boolean isUPCAEnabled() {
        return UPCA;
    }

    /**
     * Checks if the UPC-E symbology is enabled.
     * @return True if UPC-E symbology is enabled. Otherwise, returns false.
     */
    public boolean isUPCEEnabled() {
        return UPCE;
    }

    /**
     * Checks if the UPC-E1 symbology is enabled.
     * @return True if UPC-E1 symbology is enabled. Otherwise, returns false.
     */
    public boolean isUPCE1Enabled() {
        return UPCE1;
    }

    /**
     * Sets the Australian Post symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setAustralianPostEnabled(boolean enabled) {
        AustralianPost = enabled;
    }

    /**
     * Sets the Bookland EAN symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setBooklandEANEnabled(boolean enabled) {
        BooklandEAN = enabled;
    }

    /**
     * Sets the BPO symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setBPOEnabled(boolean enabled) {
        this.BPO = enabled;
    }

    /**
     * Sets the Canada Post symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setCanadaPostEnabled(boolean enabled) {
        CanadaPost = enabled;
    }

    /**
     * Sets the Chinese 2 of 5 symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setChinese2of5Enabled(boolean enabled) {
        Chinese2of5 = enabled;
    }

    /**
     * Sets the Codabar symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setCodabarEnabled(boolean enabled) {
        Codabar = enabled;
    }

    /**
     * Sets the Code 11 symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setCode11Enabled(boolean enabled) {
        Code11 = enabled;
    }

    /**
     * Sets the Code 39 symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setCode39Enabled(boolean enabled) {
        Code39 = enabled;
    }

    /**
     * Sets the Code 93 symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setCode93Enabled(boolean enabled) {
        Code93 = enabled;
    }

    /**
     * Sets the Code 128 symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setCode128Enabled(boolean enabled) {
        Code128 = enabled;
    }

    /**
     * Sets the Discrete 2 of 5 symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setDiscrete2of5Enabled(boolean enabled) {
        Discrete2of5 = enabled;
    }

    /**
     * Sets the Dutch Post symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setDutchPostEnabled(boolean enabled) {
        DutchPost = enabled;
    }

    /**
     * Sets the EAN-13 JAN-13 symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setEAN13JAN13Enabled(boolean enabled) {
        this.EAN13JAN13 = enabled;
    }

    /**
     * Sets the EAN-8 JAN-8 symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setEAN8JAN8Enabled(boolean enabled) {
        this.EAN8JAN8 = enabled;
    }

    /**
     * Sets the GS1 128 symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setGS1128Enabled(boolean enabled) {
        this.GS1128 = enabled;
    }

    /**
     * Sets the GS1 Databar (RSS) - Omni symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setGS1DatabarOmniEnabled(boolean enabled) {
        this.GS1DatabarOmni = enabled;
    }

    /**
     * Sets the GS1 Databar (RSS) - Limited symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setGS1DatabarLimitedEnabled(boolean enabled) {
        this.GS1DatabarLimited = enabled;
    }

    /**
     * Sets the GS1 Databar (RSS) - Expanded symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setGS1DatabarExpandedEnabled(boolean enabled) {
        this.GS1DatabarExpanded = enabled;
    }

    /**
     * Sets the Info Mail symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setInfoMailEnabled(boolean enabled) {
        InfoMail = enabled;
    }

    /**
     * Sets the Intelligent Mail symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setIntelligentMailEnabled(boolean enabled) {
        IntelligentMail = enabled;
    }

    /**
     * Sets the Interleaved 2 of 5 symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setInterleaved2of5Enabled(boolean enabled) {
        Interleaved2of5 = enabled;
    }

    /**
     * Sets the ISBT 128 symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setISBT128Enabled(boolean enabled) {
        this.ISBT128 = enabled;
    }

    /**
     * Sets the ISSN EAN symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setISSNEANEnabled(boolean enabled) {
        this.ISSNEAN = enabled;
    }

    /**
     * Sets the Japan Post symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setJapanPostEnabled(boolean enabled) {
        JapanPost = enabled;
    }

    /**
     * Sets the Korean 3 of 5 symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setKorean3of5Enabled(boolean enabled) {
        Korean3of5 = enabled;
    }

    /**
     * Sets the Matrix 2 of 5 symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setMatrix2of5Enabled(boolean enabled) {
        Matrix2of5 = enabled;
    }

    /**
     * Sets the MSI symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setMSIEnabled(boolean enabled) {
        this.MSI = enabled;
    }

    /**
     * Sets the Planet symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setPlanetEnabled(boolean enabled) {
        Planet = enabled;
    }

    /**
     * Sets the Plessey symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setPlesseyEnabled(boolean enabled) {
        Plessey = enabled;
    }

    /**
     * Sets the Postnet symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setPostnetEnabled(boolean enabled) {
        Postnet = enabled;
    }

    /**
     * Sets the Standard 2 of 5 symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setStandard2of5Enabled(boolean enabled) {
        Standard2of5 = enabled;
    }

    /**
     * Sets the Sweden Post symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setSwedenPostEnabled(boolean enabled) {
        SwedenPost = enabled;
    }

    /**
     * Sets the Telepen symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setTelepenEnabled(boolean enabled) {
        Telepen = enabled;
    }

    /**
     * Sets the UPC-A symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setUPCAEnabled(boolean enabled) {
        this.UPCA = enabled;
    }

    /**
     * Sets the UPC-E symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setUPCEEnabled(boolean enabled) {
        this.UPCE = enabled;
    }

    /**
     * Sets the UPC-E1 symbology enabled/disabled.
     * @param enabled True to enable. False to disable.
     */
    public void setUPCE1Enabled(boolean enabled) {
        this.UPCE1 = enabled;
    }
}
