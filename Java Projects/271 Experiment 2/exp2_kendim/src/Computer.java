// Computer class (inherits from ElectronicItem)
class Computer extends ElectronicItem {
    private String operatingSystem;
    private String cpuType;
    private int ramCapacity;
    private int hddCapacity;

    public Computer(double price, int stock, String manufacturer, String brand,
                    double maxInputVoltage, double maxPowerConsumption,
                    String operatingSystem, String cpuType, int ramCapacity, int hddCapacity) {
        super(price, stock, manufacturer, brand, maxInputVoltage, maxPowerConsumption);
        this.operatingSystem = operatingSystem;
        this.cpuType = cpuType;
        this.ramCapacity = ramCapacity;
        this.hddCapacity = hddCapacity;
    }

    // Other methods specific to Computer can be added

}
