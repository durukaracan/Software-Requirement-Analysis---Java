// SkinCare class (inherits from CosmeticItem)
class SkinCare extends CosmeticItem {
    private boolean isBabySensitive;

    public SkinCare(double price, int stock, String manufacturer, String brand, boolean isBabySensitive) {
        super(price, stock, manufacturer, brand);
        this.isBabySensitive = isBabySensitive;
    }

    // Other methods specific to SkinCare can be added

}