// Item class
class Item {
    private static int itemCounter = 1;

    private int itemID;
    private double price;
    private int stock;
    private String name;
    private String category;
    private String brand;

    public Item(double price, int stock, String name, String category, String brand) {
        this.itemID = itemCounter++;
        this.price = price;
        this.stock = stock;
        this.name = name;
        this.category = category;
        this.brand = brand;
    }
    public Item(double price, int stock) {
        this.itemID = itemCounter++;
        this.price = price;
        this.stock = stock;
    }

    public int getItemID() {
        return itemID;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getBrand() {
        return brand;
    }
    public String getType() {
        return "Generic Item";  // You can return a default type or override in subclasses
    }
    public String getManufacturer() {
        return "Generic Manufacturer";  // You can return a default manufacturer or override in subclasses
    }
    // Other methods can be added based on your requirements
}
