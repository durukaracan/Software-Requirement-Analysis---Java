// Perfume class (inherits from CosmeticItem)
class Perfume extends CosmeticItem {
    private int lastingDuration;

    public Perfume(double price, int stock, String manufacturer, String brand, int lastingDuration) {
        super(price, stock, manufacturer, brand);
        this.lastingDuration = lastingDuration;
    }

    // Other methods specific to Perfume can be added

}