package cec;

import java.util.Map;
import java.util.HashMap;

//Java compatible enums for Vendor Ids based
//on cec_vendor_id enums used by Pulse-Eight in LibCEC
public enum CECVendorId {

    Toshiba      (0x000039),
    Samsung      (0x0000F0),
    Denon        (0x0005CD),
    Marantz      (0x000678),
    Loewe        (0x000982),
    Onkyo        (0x0009B0),
    Medion       (0x000CB8),
    Toshiba2     (0x000CE7),
    PulseEight   (0x001582),
    Akai         (0x0020C7),
    AOC          (0x002467),
    Panasonic    (0x008045),
    Philips      (0x00903E),
    Daewoo       (0x009053),
    Yamaha       (0x00A0DE),
    Grundig      (0x00D0D5),
    Pioneer      (0x00E036),
    LG           (0x00E091),
    Sharp        (0x08001F),
    Sony         (0x080046),
    Broadcom     (0x18C086),
    Vizio        (0x6B746D),
    Benq         (0x8065E9),
    HarmanKardon (0x9C645E),
    Unknown      (0);

    private long id;

    private static final Map<Long, CECVendorId> vendorsById = new HashMap<>();

    static {
        for (CECVendorId vendorId : CECVendorId.values()) {
            vendorsById.put(vendorId.id, vendorId);
        }
    }

    private CECVendorId(long id) {
        this.id = id;
    }

    public static String vendorNameFromId(long id) {
        CECVendorId vendorId = vendorsById.get(id);
        if (vendorId == null) {
            vendorId = CECVendorId.Unknown;
        }
        return vendorId.name();
    }
}
