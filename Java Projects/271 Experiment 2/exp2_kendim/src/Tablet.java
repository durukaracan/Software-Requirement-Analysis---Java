// Tablet class (inherits from Computer)
class Tablet extends Computer {
    private String dimensions;

    public Tablet(double price, int stock, String manufacturer, String brand,
                  double maxInputVoltage, double maxPowerConsumption,
                  String operatingSystem, String cpuType, int ramCapacity, int hddCapacity,
                  String dimensions) {
        super(price, stock, manufacturer, brand, maxInputVoltage, maxPowerConsumption,
                operatingSystem, cpuType, ramCapacity, hddCapacity);
        this.dimensions = dimensions;
    }

    // Other methods specific to Tablet can be added

}