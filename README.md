# AML Barcode Scanner Library

## Overview

AML Barcode Scanner Library provides an easy way to interface with an AML device's barcode scanner.
The library allows you to create an instance of AMLBarcodeScanner.
You can listen for incoming barcode scan data and configure scanner settings.
This library works for native Android implementations.

## Usage

Add jitpack.io reference to build.gradle repositories section.
```java
maven { url 'https://jitpack.io' }
```
Add reference to project to the build.gradle dependencies. Replace VERSION with the version tag.
```java
implementation 'com.github.amldevicemgr:amlscannerlib:VERSION'
```

The library contains a class called `AMLBarcodeScanner` that is used to interface with the scanner:

```java
AMLBarcodeScanner scanner = new AMLBarcodeScanner(this);
```

The parameter for the constructor is the `Context` of the Android application.

## Example

Opening the scanner and registering for scan data.

```java
public AMLBarcodeScanner scanner;

public void initScanner()
{
    scanner = new AMLBarcodeScanner(this);

    //Open the scanner connection
    scanner.open();
    scanner.setOnScannedListener(new OnScannedListener() {
        @Override
        public void onScanned(String barcode, String rawBarcode) {
            //Process barcode data
        }
    });   
}
```

Querying and updating scanner settings.

```java
public void queryScannerSettings()
{
    scanner.getScannerSettings(new OnReceiveSettings() {
        @Override
        public void onReceive(ScannerSettings settings) {
            String suffix = settings.getSuffix();
            if (suffix == null || !suffix.equals("!"))
            {
                //Set suffix
                settings.setSuffix("!");
                scanner.changeSettings(settings);
            }
        }
    }); 
}
```

Registering for trigger events.

```java
public void registerTriggerEvents()
{
    scanner.setOnTriggerPulledListener(new OnTriggerPulledListener() {
        @Override
        public void onTriggerPulled() {
        }
    });
    
    scanner.setOnTriggerReleasedListener(new OnTriggerReleasedListener() {
        @Override
        public void onTriggerReleased() {
        }
    });
}
```

Querying BT Scanner and registering for events.

```java
BTDeviceInfo storedBTScanner;

public void getCurrentBTDevice()
{
    if (AMLDevice.isBTScannerSupported(getApplicationContext()))
    {
        scanner.getBTScannerInfo(new OnReceiveBTDeviceInfo() {
            @Override
            public void onReceive(BTDeviceInfo btDevice) {
                /*BTDeviceInfo will never be null. If there is not a bt scanner stored for the device, all properties
                of BTDeviceInfo will be empty strings.*/
                String btName = btDevice.getBTName();
                if (btName != null && !btName.equals(""))
                {
                    storedBTScanner = btDevice;
                    registerBTScannerEvents();
                }
            }
        });
    }
}

public void registerBTScannerEvents()
{
    scanner.setOnBTScannerConnected(new OnBTScannerConnected() {
        @Override
        public void onBTScannerConnected(BTScanDevice btDevice) {
            //Implement handling
        }
    });

    scanner.setOnBTScannerDisconnected(new OnBTScannerDisconnected() {
        @Override
        public void onBTScannerDisconnected(BTScanDevice btDevice) {
            //Implement handling
        }
    });
        
    scanner.setOnBTScannerLowBattery(new OnBTScannerLowBattery() {
        @Override
        public void onBTScannerLowBattery(int battery) {
            //Implement handling
        }
    });
}
```