package cec;

import java.util.HashMap;
import java.util.Map;

public enum CECLogicalAddress {

    Unknown          (-1),
    Tv               (0),
    RecordingDevice1 (1),
    RecordingDevice2 (2),
    Tuner1           (3),
    PlaybackDevice1  (4),
    AudioSystem      (5),
    Tuner2           (6),
    Tuner3           (7),
    PlaybackDevice2  (8),
    RecordingDevice3 (9),
    Tuner4           (10),
    PlaybackDevice3  (11),
    Reserved1        (12),
    Reserved2        (13),
    FreeUse          (14),
    Unregistered     (15),
    Broadcast        (15);

    private int address;

    private CECLogicalAddress(int address) {
        this.address = address;
    }

    private static final Map<Integer, CECLogicalAddress> addressByIntVal = new HashMap<>();
    static {
        for (CECLogicalAddress logicalAddress : CECLogicalAddress.values()) {
            addressByIntVal.put(logicalAddress.address, logicalAddress);
        }
    }

    public static CECLogicalAddress addressFromInt(int i) {
        CECLogicalAddress address = addressByIntVal.get(i);
        if (address == null) {
            address = CECLogicalAddress.Unknown;
        }
        return address;
    }
}

