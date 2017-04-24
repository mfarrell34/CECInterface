package cec;

public class Main {

        public static void main(String[] args) {
                // TODO Auto-generated method stub

                LibCEC cecInterface = LibCEC.initialize(true);

        String[] adapterList = cecInterface.getAdapters();
        for (String adapter : adapterList) {
            System.out.println(adapter);
        }

        if (adapterList.length > 0) {
            boolean success = cecInterface.open(adapterList[0]);
            System.out.println("Connection - " + (success ? "Successful" : "Failed"));
            if (success) {

  //              int[] devices = cecInterface.getActiveDevices();

                System.out.println("Is TV on?");
                boolean tvOn = cecInterface.isTVOn();
                System.out.println(tvOn);

                if (!tvOn) {
                    cecInterface.powerOnTV();
                }
            }
        //    cecInterface.sendKeyPress(0,CECUserControlCode.PowerOffFunction.getControlCode());
        }
        cecInterface.cleanUp();
        }

}
