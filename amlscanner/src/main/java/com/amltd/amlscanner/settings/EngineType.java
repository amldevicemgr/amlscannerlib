package com.amltd.amlscanner.settings;

enum EngineType {
    UNKNOWN(0),
    GENERIC(1),
    EX25(2),
    SE965(3),
    Z475733(4),
    EX30(5),
    N5680(6),
    IT5180(7),
    SE2707(8),
    SE3307(9),
    SE4107(10),
    Z475750(11),
    N4680(12),
    SE655(13),
    N5780(14);

    private final int value;

    private EngineType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
