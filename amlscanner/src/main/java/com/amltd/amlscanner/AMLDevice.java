package com.amltd.amlscanner;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.Log;

public class AMLDevice {
    /**
     * Get the AML model name.
     * @return The devices AML model or null if the device is not AML.
     */
    public static String getAMLModel() {
        String model = Build.MODEL;
        String amlModel = null;
        switch (model)
        {
            case "M7700":
                amlModel = "M7700";
                break;
            case "M7800":
                amlModel = "M7800";
                break;
            case "M6500":
                amlModel = "M6500";
                break;
            case "KDT7":
                amlModel = "KDT7";
                break;
            case "M7800 BATCH":
                amlModel = "M7800 BATCH";
                break;
        }
        return amlModel;
    }

    /**
     * Checks whether the device is an AML device.
     * @return True if the device is AML, otherwise returns false.
     */
    public static boolean isAMLDevice() {
        String model = Build.MODEL;
        return model.equals("M7700") || model.equals("M7800") || model.equals("M6500") || model.equals("KDT7") || model.equals("M7800 BATCH");
    }

    /**
     * Checks whether the device supports BT Scanner.
     * @param context The context of the application.
     * @return True if the device is supports BT Scanner, otherwise returns false.
     */
    public static boolean isBTScannerSupported(Context context) {
        try
        {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.amltd.amlbarcodescanner", 0);
            return packageInfo.versionCode >= 179 && isAMLDevice();
        }
        catch (Exception e)
        {
            Log.d("AMLBarcodeScannerLib", "Package not found.");
        }
        return false;
    }

    /**
     * Gets the AML Barcode Scanner version.
     * @param context The context of the application.
     * @return The version of AML Barcode Scanner if installed, otherwise -1.
     */
    public static int getAMLBarcodeScannerVersion(Context context)
    {
        try
        {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.amltd.amlbarcodescanner", 0);
            return packageInfo.versionCode;
        }
        catch (Exception e)
        {
            Log.d("AMLBarcodeScannerLib", "Package not found.");
        }
        return -1;
    }
}
