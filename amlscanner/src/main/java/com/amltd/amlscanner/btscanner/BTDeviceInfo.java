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
        if (Battery != null && !Battery.equals(""))
        {
            String percent = Battery;
            int index = percent.lastIndexOf("/");
            int percentIndex = percent.lastIndexOf("]");
            if (index != -1 && percentIndex != -1)
            {
                percent = percent.substring(index + 1, percentIndex);
                return percent;
            }
            else
                return Battery;
        }
        else
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
