package com.amltd.amlscanner.settings;

public enum KeyboardWedgeMode {
    FASTINPUT(0),
    TRUEKEYPRESS(1);

    private final int value;

    private KeyboardWedgeMode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
