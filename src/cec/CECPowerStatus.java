package cec;

import java.util.Map;
import java.util.HashMap;

//Java compatible enums for device power status based
//on cec_power_status enums used by Pulse-Eight in LibCEC
public enum CECPowerStatus {

    On                      (0x00),
    Standby                 (0x01),
    InTransitionStandbyToOn (0x02),
    InTransitionOnToStandby (0x03),
    Unknown                 (0x99);

    private int status;

    private CECPowerStatus(int status) {
        this.status = status;
    }

    private static final Map<Integer,CECPowerStatus> statusByIntVal = new HashMap<>();
    static {
        for (CECPowerStatus powerStatus : CECPowerStatus.values()) {
            statusByIntVal.put(powerStatus.status, powerStatus);
        }
    }

    public static CECPowerStatus fromInt(int i) {
        CECPowerStatus status = statusByIntVal.get(i);
        if (status == null) {
            status = CECPowerStatus.Unknown;
        }
        return status;
    }
}
