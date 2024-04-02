package com.amltd.amlscanner.btscanner;

public class BTDeviceInfo {
    private String Name;
    private String Address;
    private String ServiceUuid;
    private String Battery;
    private boolean IsConnected;

    public String getBTName()
    {
        return Name;
    }

    public String getBtAddress()
    {
        return Address;
    }

    public String getBattery()
    {
        return Battery;
    }

    public String getServiceUuid()
    {
        return ServiceUuid;
    }

    public boolean IsScannerConnected()
    {
        return IsConnected;
    }
}
