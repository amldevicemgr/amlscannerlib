package com.amltd.amlscanner;

import com.amltd.amlscanner.btscanner.BTDeviceInfo;

public interface OnReceiveBTDeviceInfo {
    void onReceive(BTDeviceInfo btDevice);
}
