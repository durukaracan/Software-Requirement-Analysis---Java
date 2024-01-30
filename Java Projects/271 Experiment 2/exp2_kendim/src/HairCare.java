// HairCare class (inherits from CosmeticItem)
class HairCare extends CosmeticItem {
    private boolean isMedicated;

    public HairCare(double price, int stock, String manufacturer, String brand, boolean isMedicated) {
        super(price, stock, manufacturer, brand);
        this.isMedicated = isMedicated;
    }

    // Other methods specific to HairCare can be added

}