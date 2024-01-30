// Technician class (inherits from Employee)
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
class Technician extends Employee {
    private boolean isSenior;
    private static List<Admin> admins = new ArrayList<>();
    private static List<Technician> technicians = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private static List<Item> items = new ArrayList<>();


    public Technician(String name, String email, String dateOfBirth, double salary, boolean isSenior) {
        super(name, email, dateOfBirth, salary);
        this.isSenior = isSenior;
        technicians.add(this);
    }

    public boolean isSeniorTechnician() {
        return isSenior;
    }

    //event action 7
    public static void listItems(String employeeName) {
        Employee employee = findEmployeeByName(employeeName);

        if (employee != null) {
            System.out.println("Items information for " + employeeName + ":");

            if (!items.isEmpty()) {
                for (Item item : items) {
                    System.out.println("Type: " + item.getType());
                    System.out.println("Item ID: " + item.getItemID());
                    System.out.println("Price: " + item.getPrice() + " $");
                    System.out.println("Manufacturer: " + item.getManufacturer());
                    System.out.println("Brand: " + item.getBrand());

                    if (item instanceof ElectronicItem) {
                        ElectronicItem electronicItem = (ElectronicItem) item;
                        System.out.println("Max Input Voltage: " + electronicItem.getMaxInputVoltage() + " V.");
                        System.out.println("Max Power Consumption: " + electronicItem.getMaxPowerConsumption() + " W.");
                    } else if (item instanceof CosmeticItem) {
                        CosmeticItem cosmeticItem = (CosmeticItem) item;
                        // CosmeticItem-specific properties
                    }

                    System.out.println("-----------------------");

                }
            }
        }
    }
    // Method to find an employee by name
    private static Employee findEmployeeByName(String employeeName) {
        for (Admin admin : admins) {
            if (admin.getName().equals(employeeName)) {
                return admin;
            }
        }

        for (Technician technician : technicians) {
            if (technician.getName().equals(employeeName)) {
                return technician;
            }
        }

        return null;
    }

    //event action 8 to show items with low stock
    public static void showItemsLowOnStock(String employeeName, int maxStockAmount) {
        Employee employee = findEmployeeByName(employeeName);

        if (employee != null) {
            System.out.println("Items with low stock for " + employeeName + ":");

            if (!items.isEmpty()) {
                for (Item item : items) {
                    if (item.getStock() < maxStockAmount) {
                        System.out.println(item.getType() + " : " + item.getStock());
                    }
                }
            } else {
                System.out.println("No items recorded in the system.");
            }
        } else {
            System.out.println("No admin or technician person named " + employeeName + " exists!");
        }
    }

    // New method to show VIP customers

    public static void showVipCustomers(String employeeName) {
        Employee employee = findEmployeeByName(employeeName);

        if (employee != null) {
            System.out.println("VIP Customers for " + employeeName + ":");

            if (!customers.isEmpty()) {
                for (Customer customer : customers) {
                    if ("GOLDEN".equals(customer.getStatus())) {
                        System.out.println("Customer name: " + customer.getName() +
                                " ID: " + customer.getCustomerID() +
                                " e-mail: " + customer.getEmail() +
                                " Date of Birth: " + customer.getDateOfBirth() +
                                " Status: " + customer.getStatus());
                    }
                }
            } else {
                System.out.println("No customers recorded in the system.");
            }
        } else {
            System.out.println("No admin or technician person named " + employeeName + " exists!");
        }
    }
    public static void displayItemsOf(String technicianName, String itemTypes) {
        Technician technician = findTechnicianByName(technicianName);

        if (technician != null) {
            System.out.println("Items for " + technicianName + " under specific types:");

            if (!items.isEmpty()) {
                String[] types = itemTypes.split(":");
                for (Item item : items) {
                    for (String type : types) {
                        if (item.getType().equalsIgnoreCase(type.trim())) {
                            // Display item information
                            displayItemInfo(item);
                            System.out.println("-----------------------");
                            break;
                        }
                    }
                }
            } else {
                System.out.println("No items recorded in the system.");
            }
        } else {
            System.out.println("No technician person named " + technicianName + " exists!");
        }
    }

    // Helper method to display item information
    private static void displayItemInfo(Item item) {
        System.out.println("Type: " + item.getType());
        System.out.println("Item ID: " + item.getItemID());
        System.out.println("Price: " + item.getPrice() + " $");

        // Display common properties or any additional properties based on the item type
        if (item instanceof ElectronicItem) {
            ElectronicItem electronicItem = (ElectronicItem) item;
            System.out.println("Max Input Voltage: " + electronicItem.getMaxInputVoltage() + " V.");
            System.out.println("Max Power Consumption: " + electronicItem.getMaxPowerConsumption() + " W.");
        } else if (item instanceof CosmeticItem) {
            CosmeticItem cosmeticItem = (CosmeticItem) item;
            System.out.println("Manufacturer: " + cosmeticItem.getManufacturer());
            System.out.println("Brand: " + cosmeticItem.getBrand());
            // Display CosmeticItem-specific properties
        } else if (item instanceof Book) {
            Book book = (Book) item;
            System.out.println("Release Date: " + book.getReleaseDate());
            System.out.println("Title: " + book.getCoverTitle());
            System.out.println("Publisher: " + book.getPublisher());
            System.out.println("Authors: " + book.getAuthors());
            System.out.println("Number of Pages: " + book.getNumberOfPages() + " pages");
        }
        // Add more conditions for other item types if needed
    }

    // Helper method to find a technician by name
    private static Technician findTechnicianByName(String technicianName) {
        for (Technician technician : technicians) {
            if (technician.getName().equals(technicianName)) {
                return technician;
            }
        }
        return null;
    }

    // Yeni method: addItem
    public void addItem(String itemType, String... arguments) {
        // Find the item type
        ItemType type = ItemType.fromString(itemType);

        if (type == null) {
            System.out.println("No item type " + itemType + " found");
            return;
        }

        // Check if the technician exists
        if (!technicians.contains(this)) {
            System.out.println("No technician person named " + getName() + " exists!");
            return;
        }

        // Create and add the new item
        Item newItem = createNewItem(type, arguments);
        if (newItem != null) {
            items.add(newItem);
            System.out.println("Item added successfully!");
        } else {
            System.out.println("Failed to create the item. Please check the arguments.");
        }
    }

    // Create a new item based on item type and arguments
    private Item createNewItem(ItemType type, String... arguments) {
        switch (type) {
            case COSMETIC_ITEM:
                return createCosmeticItem(arguments);
            case ELECTRONIC_ITEM:
                return createElectronicItem(arguments);
            case OFFICE_SUPPLIES_ITEM:
                return createOfficeSuppliesItem(arguments);
            // Add cases for other item types
            default:
                break;
        }
        return null;
    }

    // Create a CosmeticItem based on arguments
    private CosmeticItem createCosmeticItem(String... arguments) {
        // Check if there are enough arguments
        if (arguments.length < 2) {
            System.out.println("Not enough arguments for creating a CosmeticItem.");
            return null;
        }

        double price = Double.parseDouble(arguments[0]);
        int stock = Integer.parseInt(arguments[1]);
        String manufacturer = arguments[2];
        String brand = arguments[3];

        // Create and return a new CosmeticItem
        return new CosmeticItem(price, stock, manufacturer, brand);
    }

    // Create an ElectronicItem based on arguments
    private ElectronicItem createElectronicItem(String... arguments) {
        // Check if there are enough arguments
        if (arguments.length < 6) {
            System.out.println("Not enough arguments for creating an ElectronicItem.");
            return null;
        }

        double price = Double.parseDouble(arguments[0]);
        int stock = Integer.parseInt(arguments[1]);
        String manufacturer = arguments[2];
        String brand = arguments[3];
        double maxInputVoltage = Double.parseDouble(arguments[4]);
        double maxPowerConsumption = Double.parseDouble(arguments[5]);

        // Create and return a new ElectronicItem
        return new ElectronicItem(price, stock, manufacturer, brand, maxInputVoltage, maxPowerConsumption);
    }

    // Create an OfficeSuppliesItem based on arguments
    private OfficeSuppliesItem createOfficeSuppliesItem(String... arguments) {
        // Check if there are enough arguments
        if (arguments.length < 4) {
            System.out.println("Not enough arguments for creating an OfficeSuppliesItem.");
            return null;
        }

        double price = Double.parseDouble(arguments[0]);
        int stock = Integer.parseInt(arguments[1]);
        String releaseDate = arguments[2];
        String coverTitle = arguments[3];

        // Create and return a new OfficeSuppliesItem
        return new OfficeSuppliesItem(price, stock, releaseDate, coverTitle);
    }

    public void showOrders(String technicianName) {
        // Check if the technician exists
        if (!technicians.contains(this)) {
            System.out.println("No technician person named " + getName() + " exists!");
            return;
        }

        // Check if the technician is a senior technician
        if (!isSeniorTechnician()) {
            System.out.println(getName() + " is not authorized to display orders!");
            return;
        }

        // Display order history
        System.out.println("Order History:");

        for (Order order : orders) {
            System.out.println("Order date: " + order.getOrderDate() +
                    " Customer ID: " + order.getCustomerID() +
                    " Total Cost: " + order.getTotalCost() +
                    " Number of purchased items: " + order.getPurchasedItems());
        }
    }
}

