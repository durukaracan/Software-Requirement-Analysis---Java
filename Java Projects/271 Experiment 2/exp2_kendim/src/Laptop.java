// Laptop class (inherits from Computer)
class Laptop extends Computer {
    private boolean hasHdmiSupport;

    public Laptop(double price, int stock, String manufacturer, String brand,
                  double maxInputVoltage, double maxPowerConsumption,
                  String operatingSystem, String cpuType, int ramCapacity, int hddCapacity,
                  boolean hasHdmiSupport) {
        super(price, stock, manufacturer, brand, maxInputVoltage, maxPowerConsumption,
                operatingSystem, cpuType, ramCapacity, hddCapacity);
        this.hasHdmiSupport = hasHdmiSupport;
    }

    // Other methods specific to Laptop can be added
    @Override
    public String getType() {
        return "Laptop";
    }
}