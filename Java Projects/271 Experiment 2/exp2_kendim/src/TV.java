// TV class (inherits from ElectronicItem)
class TV extends ElectronicItem {
    private int screenSizeInInches;

    public TV(double price, int stock, String manufacturer, String brand,
              double maxInputVoltage, double maxPowerConsumption, int screenSizeInInches) {
        super(price, stock, manufacturer, brand, maxInputVoltage, maxPowerConsumption);
        this.screenSizeInInches = screenSizeInInches;
    }
    @Override
    public String getType() {
        return "TV";
    }

    public int getScreenSizeInInches() {
        return screenSizeInInches;
    }
// Other methods specific to TV can be added

}