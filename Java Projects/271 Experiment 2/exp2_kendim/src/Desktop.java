// Desktop class (inherits from Computer)
class Desktop extends Computer {
    private String boxColor;

    public Desktop(double price, int stock, String manufacturer, String brand,
                   double maxInputVoltage, double maxPowerConsumption,
                   String operatingSystem, String cpuType, int ramCapacity, int hddCapacity,
                   String boxColor) {
        super(price, stock, manufacturer, brand, maxInputVoltage, maxPowerConsumption,
                operatingSystem, cpuType, ramCapacity, hddCapacity);
        this.boxColor = boxColor;
    }



    // Other methods specific to Desktop can be added

    public String getBoxColor() {
        return boxColor;
    }
}