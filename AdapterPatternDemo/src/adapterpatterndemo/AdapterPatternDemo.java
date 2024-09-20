
package adapterpatterndemo;

/**
 *
 * @author sanja
 */
interface AmericanPlug {
    void plugIn110V();
}

class AmericanDevice implements AmericanPlug {
    @Override
    public void plugIn110V() {
        System.out.println("American device plugged in with 110V");
    }
}

interface EuropeanPlug {
    void plugIn220V();
}

class VoltageAdapter implements EuropeanPlug {
    private AmericanPlug americanDevice;

    public VoltageAdapter(AmericanPlug americanDevice) {
        this.americanDevice = americanDevice;
    }

    @Override
    public void plugIn220V() {
        System.out.println("Adapter converting 220V to 110V...");
        americanDevice.plugIn110V();
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        AmericanPlug device = new AmericanDevice();
        EuropeanPlug adapter = new VoltageAdapter(device);

        adapter.plugIn220V(); // Using adapter to convert the voltage and plug in the American device
    }
}
