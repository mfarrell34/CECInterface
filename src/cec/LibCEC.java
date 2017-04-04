package cec;

public class LibCEC {
	
    static {
        System.loadLibrary("cec-interface");
    }

    //singleton instance can only be initialized once
    //as init() will create native c++ LibCEC object stored in handle
    private static LibCEC instance;
    private static boolean initialized = false;

    //handle pointing to native LibCEC object
    private long nativeHandle;
	
    private LibCEC() {
    };
	
    public static LibCEC initialize() {
        if (!initialized) {
            instance = new LibCEC();
            instance.init();
            initialized = true;
        }
        return instance;
    }

    public boolean isTVOn() {
        boolean isOn = false;
        if (initialized) {
            int[] devices = getActiveDevices();
            for (int i = 0; i < devices.length; i++) {
                if ((CECLogicalAddress.addressFromInt(devices[i]) ==
                    CECLogicalAddress.Tv) && 
                    CECPowerStatus.fromInt(getDevicePowerStatus(devices[i])) ==
                    CECPowerStatus.On ) {
                    isOn = true;
                }
            }
        }
        return isOn;
    }

    //initializes native c++ LibCEC object with default configuration
    private native void init();

    //opens connection to adapter, pass name of com port for adapter
    public native boolean open(String port);

    //returns array of strings containing com port names of detected adapters
    public native String[] getAdapters();

    //pass logical address of device to power it on
    public native boolean powerOnDevice(int address);

    //calls default c++ function for powerOnDevice which will power on TV
    public native boolean powerOnTV();

    //returns array containing logical addresses of active devices detected by LibCEC
    public native int[] getActiveDevices();

    //gets Vendor Id for a device identified by its logical address
    public native long getDeviceVendorId(int address);

    //get power status for a device identified by its logical address
    public native int getDevicePowerStatus(int address);

    //close connection to LibCEC adapter
    public native void close();

    //call to handle cleanup of native c++ resources
    public native void dispose();
}
