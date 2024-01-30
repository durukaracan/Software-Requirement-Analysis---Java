// CosmeticItem class (inherits from Item)
class CosmeticItem extends Item {
    private String manufacturer;
    private String brand;

    public CosmeticItem(double price, int stock, String manufacturer, String brand) {
        super(price, stock);
        this.manufacturer = manufacturer;
        this.brand = brand;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String getBrand() {
        return brand;
    }
// Other methods specific to CosmeticItem can be added

}
