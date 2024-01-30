// ElectronicItem class (inherits from Item)
class ElectronicItem extends Item {
    private String manufacturer;
    private String brand;
    private double maxInputVoltage;
    private double maxPowerConsumption;

    public ElectronicItem(double price, int stock, String manufacturer, String brand,
                          double maxInputVoltage, double maxPowerConsumption) {
        super(price, stock);
        this.manufacturer = manufacturer;
        this.brand = brand;
        this.maxInputVoltage = maxInputVoltage;
        this.maxPowerConsumption = maxPowerConsumption;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    public double getMaxInputVoltage() {
        return maxInputVoltage;
    }

    public double getMaxPowerConsumption() {
        return maxPowerConsumption;
    }
// Other methods specific to ElectronicItem can be added

}