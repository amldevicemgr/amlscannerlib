package com.amltd.amlscanner.settings;

public enum PresentationMode {
    MANUALTRIGGER(0),
    NORMALPRESENTATION(2),
    MOBILEPRESENTATION (3),
    STREAMINGPRESENTATION(4);

    private final int value;

    private PresentationMode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
