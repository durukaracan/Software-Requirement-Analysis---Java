// SmartPhone class (inherits from ElectronicItem)
class SmartPhone extends ElectronicItem {
    private String screenType;

    public SmartPhone(double price, int stock, String manufacturer, String brand,
                      double maxInputVoltage, double maxPowerConsumption, String screenType) {
        super(price, stock, manufacturer, brand, maxInputVoltage, maxPowerConsumption);
        this.screenType = screenType;
    }
    @Override
    public String getType() {
        return "SmartPhone";
    }

    public String getScreenType() {
        return screenType;
    }
    // Other methods specific to SmartPhone can be added

}