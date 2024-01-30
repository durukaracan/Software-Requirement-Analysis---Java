import java.util.ArrayList;
import java.util.List;
// Admin class (inherits from Employee)
class Admin extends Employee {
    private String password;
    private static List<Admin> admins = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private static List<Campaign> campaigns = new ArrayList<>();
    private static List<Technician> technicians = new ArrayList<>();
    private static List<Item> items = new ArrayList<>();

    public Admin(String name, String email, String dateOfBirth, double salary, String password) {
        super(name, email, dateOfBirth, salary);
        this.password = password;
        admins.add(this);
    }


    public static void addCustomer(String adminName, String customerName, String customerMail,
                                   String customerDateOfBirth, double initialBalance, String password) {
        Admin admin = findAdminByName(adminName);
        if (admin != null) {
            // Admin exists, proceed with adding a new customer
            Customer newCustomer = new Customer(customerName, customerMail, customerDateOfBirth, password);
            newCustomer.updateBalance(initialBalance);
            customers.add(newCustomer);
            System.out.println("Customer added successfully!");
        } else {
            System.out.println("No admin person named " + adminName + " exists!");
        }
    }
    private static Admin findAdminByName(String adminName) {
        for (Admin admin : admins) {
            if (admin.getName().equals(adminName)) {
                return admin;
            }
        }
        return null;
    }

    public static void showCustomerInfo(String adminName, int customerID) {
        Admin admin = findAdminByName(adminName);
        if (admin != null) {
            // Admin exists, proceed with showing customer info
            Customer customer = findCustomerByID(customerID);
            if (customer != null) {
                System.out.println("Customer name: " + customer.getName() +
                        " ID: " + customer.getCustomerID() +
                        " e-mail: " + customer.getEmail() +
                        " Date of Birth: " + customer.getDateOfBirth() +
                        " Status: " + customer.getStatus());
            } else {
                System.out.println("No customer found with ID: " + customerID);
            }
        } else {
            System.out.println("No admin person named " + adminName + " exists!");
        }
    }
    // for SHOWCUSTOMER mainde falan çağırcan input olarak method bu
    public static void showCustomers(String adminName) {
        Admin admin = findAdminByName(adminName);
        if (admin != null) {
            // Admin exists, proceed with showing customer info
            System.out.println("Customer information for admin " + adminName + ":");

            if (!customers.isEmpty()) {
                for (Customer customer : customers) {
                    System.out.println("Customer name: " + customer.getName() +
                            " ID: " + customer.getCustomerID() +
                            " e-mail: " + customer.getEmail() +
                            " Date of Birth: " + customer.getDateOfBirth() +
                            " Status: " + customer.getStatus());
                }
            } else {
                System.out.println("No customers recorded in the system.");
            }
        } else {
            System.out.println("No admin person named " + adminName + " exists!");
        }
    }
    private static Customer findCustomerByID(int customerID) {
        for (Customer customer : customers) {
            if (customer.getCustomerID() == customerID) {
                return customer;
            }
        }
        return null;
    }


    public void displayCustomerData(String customerID) {
        // Implementation
    }

    public void displayAllCustomers() {
        // Implementation
    }

    // event/action 4 SHOWADMININFO<TAB>adminName
    public static void showAdminInfo(String adminName) {
        Admin admin = findAdminByName(adminName);
        if (admin != null) {
            admin.displayPersonalData();  // Utilize existing method to display personal data
        } else {
            System.out.println("No admin person named " + adminName + " exists!");
        }
    }
    @Override
    public void displayPersonalData() {
        System.out.println("---------- Admin info -----------");
        System.out.println("Admin name: " + getName());
        System.out.println("Admin e-mail: " + getEmail());
        System.out.println("Admin date of birth: " + getDateOfBirth());
    }


    public static void launchCampaign(String adminName, String startDate, String endDate, String itemType, double rate) {
        Admin admin = findAdminByName(adminName);
        if (admin != null) {
            if (rate > Campaign.MAX_DISCOUNT_RATE) {
                System.out.println("Campaign was not created. Discount rate exceeds maximum rate of " + Campaign.MAX_DISCOUNT_RATE + "%.");
            } else {
                // Check if a campaign already exists for the specified item type
                if (campaignExists(itemType)) {
                    System.out.println("Campaign was not created. A campaign already exists for the item type: " + itemType);
                } else {
                    // Create and add the new campaign
                    Campaign newCampaign = new Campaign(startDate, endDate, itemType, rate);
                    campaigns.add(newCampaign);
                    System.out.println("Campaign created successfully!");
                }
            }
        } else {
            System.out.println("No admin person named " + adminName + " exists!");
        }
    }

    private static boolean campaignExists(String itemType) {
        // Check if a campaign already exists for the specified item type
        for (Campaign campaign : campaigns) {
            if (campaign.getItemType().equalsIgnoreCase(itemType)) {
                return true;
            }
        }
        return false;
    }

    // event action 6 Add a new employee:
    public static void addAdmin(String adminName, String newAdminName, String newAdminMail,
                                String newAdminDateOfBirth, double newAdminSalary, String newAdminPassword) {
        Admin admin = findAdminByName(adminName);
        if (admin != null) {
            // Admin exists, proceed with adding a new admin
            Admin newAdmin = new Admin(newAdminName, newAdminMail, newAdminDateOfBirth, newAdminSalary, newAdminPassword);
            admins.add(newAdmin);
            System.out.println("Admin added successfully!");
        } else {
            System.out.println("No admin person named " + adminName + " exists!");
        }
    }

    public static void addTechnician(String adminName, String newTechName, String newTechMail,
                                     String newTechDateOfBirth, double newTechSalary, int isSenior) {
        Admin admin = findAdminByName(adminName);
        if (admin != null) {
            // Admin exists, proceed with adding a new technician
            Technician newTech = new Technician(newTechName, newTechMail, newTechDateOfBirth, newTechSalary, isSenior == 1);
            technicians.add(newTech);
            System.out.println("Technician added successfully!");
        } else {
            System.out.println("No admin person named " + adminName + " exists!");
        }
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

    // New method to show VIP customers event action 9
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
}