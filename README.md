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

```java
public AMLBarcodeScanner scanner;

public initScanner()
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
