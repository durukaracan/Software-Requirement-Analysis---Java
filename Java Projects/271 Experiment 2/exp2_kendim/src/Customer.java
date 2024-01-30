import java.util.ArrayList;
import java.util.List;

// Customer class (inherits from Person)
class Customer extends Person {
    private static final double SILVER_STATUS_THRESHOLD = 1000.0;
    private static final double GOLDEN_STATUS_THRESHOLD = 5000.0;
    private static final double SILVER_DISCOUNT_RATE = 0.1;
    private static final double GOLDEN_DISCOUNT_RATE = 0.15;

    private int customerID;
    private String password;
    private double balance;
    private CustomerStatus status;
    private List<String> shoppingCart;
    private List<String> orderHistory;
    private static List<Customer> customers = new ArrayList<>();
    private static int customerCounter = 1;

    public Customer(String name, String email, String dateOfBirth, String password) {
        super(name, email, dateOfBirth);
        this.customerID = customerCounter++;
        this.password = password;
        this.balance = 0.0;
        this.status = CustomerStatus.CLASSIC;
        this.shoppingCart = new ArrayList<>();
        this.orderHistory = new ArrayList<>();
    }


    // Additional methods based on the provided specifications:



    public void updateBalance(double amount) {
        // Implement balance update logic
        this.balance += amount;
        System.out.println("Balance updated successfully. Current balance: $" + this.balance);
    }


    public void addToCart(String itemID) {
        // Check if the customer exists
        if (!customerExists()) {
            System.out.println("No customer with ID number " + getCustomerID() + " exists!");
            return;
        }

        // Find the item by ID
        Item item = findItemByID(itemID);

        // Check if the item ID is valid
        if (item == null) {
            System.out.println("Invalid item ID");
            return;
        }

        // Check if the item is available
        if (item.getStock() <= 0) {
            System.out.println("We are sorry. The item is temporarily unavailable.");
            return;
        }

        // Add the item to the shopping cart
        shoppingCart.add(String.valueOf(item));
        System.out.println("The item " + item.getType() + " has been successfully added to your cart.");
    }

    public void emptyCart() {
        // Check if the customer exists
        if (!customerExists()) {
            System.out.println("No customer with ID number " + getCustomerID() + " exists!");
            return;
        }

        // Check if the cart is already empty
        if (shoppingCart.isEmpty()) {
            System.out.println("The cart is already empty.");
            return;
        }

        // Empty the cart
        shoppingCart.clear();
        System.out.println("The cart has been emptied.");
    }

    // Correct the return type to List<Item>
    public List<String> getShoppingCart() {
        return shoppingCart;
    }

    // Helper method to find an item by ID
    private Item findItemByID(String itemID) {
        // Implement the logic to find an item by ID
        // You need to have a list of items and check if the item with the given ID is in the list
        // Replace the following return statement with your logic
        return null;
    }

    public void clearShoppingCart() {
        // Implement logic to clear the shopping cart
        this.shoppingCart.clear();
        System.out.println("Shopping cart cleared.");
    }

    // Method to convert List<String> to List<Item>
    private List<Item> convertToItems(List<String> itemIds) {
        List<Item> items = new ArrayList<>();
        // Implement logic to retrieve items from the item IDs and add them to the list
        // Replace this with your actual logic to fetch items based on item IDs
        for (String itemId : itemIds) {
            Item item = fetchItemById(itemId); // Replace with actual method to fetch item by ID
            items.add(item);
        }
        return items;
    }

    // Method to fetch item by ID (replace with your actual logic)
    private Item fetchItemById(String itemId) {
        // Implement logic to fetch item by ID from your data source
        // Replace this with your actual logic to fetch items based on item IDs

        // Örnek olarak, itemId'nin bir sayısal değer olduğunu varsayalım
        int itemIdAsInt = Integer.parseInt(itemId);

        // Gerçek verileri çekmek için veritabanı sorgusu veya başka bir kaynağı kullanın
        // Burada sadece örnek veri döndürüyorum
        return new Item(10.0, 100, "Dummy Item " + itemIdAsInt, "Dummy Category", "Dummy Brand");
    }


    private double calculateTotalCost() {
        // Implement logic to calculate the total cost of items in the shopping cart
        double totalCost = 0.0;
        // Iterate through the shopping cart and accumulate item costs
        return totalCost;
    }
    private void updateCustomerStatus() {
        // Implement logic to update customer status based on the total amount spent
        if (this.balance >= GOLDEN_STATUS_THRESHOLD) {
            this.status = CustomerStatus.GOLDEN;
        } else if (this.balance >= SILVER_STATUS_THRESHOLD) {
            this.status = CustomerStatus.SILVER;
        }
    }
    @Override
    public String toString() {
        return "Customer ID: " + customerID +
                "\nEmail: " + getEmail() +
                "\nDate of Birth: " + getDateOfBirth() +
                "\nStatus: " + status;
    }

    public int getCustomerID() {
        return customerID;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    private enum CustomerStatus {
        CLASSIC, SILVER, GOLDEN
    }
    public void changePassword(String oldPassword, String newPassword) {
        // Check if the old password matches the current password
        if (!password.equals(oldPassword)) {
            System.out.println("The given password does not match the current password. Please try again.");
            return;
        }

        // Update the password
        this.password = newPassword;
        System.out.println("The password has been successfully changed.");
    }
    public void depositMoney(double loadAmount) {
        // Check if the load amount is non-negative
        if (loadAmount < 0) {
            System.out.println("Invalid load amount. Please enter a non-negative amount.");
            return;
        }

        // Update the balance
        this.balance += loadAmount;
        System.out.println("Money deposited successfully. New balance: $" + this.balance);
    }
    public void showCampaigns() {
        // Check if the customer exists
        if (!customerExists()) {
            System.out.println("No customer with ID number " + getCustomerID() + " exists!");
            return;
        }

        // Check if there are active campaigns
        List<Campaign> activeCampaigns = Campaign.getActiveCampaigns();
        if (activeCampaigns.isEmpty()) {
            System.out.println("No campaign has been created so far!");
            return;
        }

        // Display active campaigns
        System.out.println("Active campaigns:");
        for (Campaign campaign : activeCampaigns) {
            // Assuming you have a getDescription() method in the Campaign class
            System.out.println("Campaign ID: " + campaign.getCampaignID() +
                    ", Start Date: " + campaign.getStartDate() +
                    ", End Date: " + campaign.getEndDate() +
                    ", Item Type: " + campaign.getItemType() +
                    ", Discount Rate: " + campaign.getDiscountRate() + "%");
        }
    }

    private boolean customerExists() {
        // Check if the customer exists in the list
        return customers.contains(this);
    }

    public void placeOrder(String enteredPassword) {
        // Check if the customer exists
        if (!customerExists()) {
            System.out.println("No customer with ID number " + getCustomerID() + " exists!");
            return;
        }

        // Check if the cart is empty
        if (shoppingCart.isEmpty()) {
            System.out.println("You should add some items to your cart before order request!");
            return;
        }

        // Check if the entered password is valid
        if (!password.equals(enteredPassword)) {
            System.out.println("Order could not be placed. Invalid password.");
            return;
        }

        // Calculate the total price considering customer status and active campaigns
        double totalPrice = calculateTotalPrice();

        // Check if the customer has enough funds
        if (balance < totalPrice) {
            System.out.println("Order could not be placed. Insufficient funds.");
            return;
        }

        // Process the order and give feedback
        processOrder(totalPrice);
    }

    // Other methods...

    // Helper method to calculate the total price considering customer status and active campaigns
    private double calculateTotalPrice() {
        // Implement the logic to calculate the total price
        // You need to consider customer status (GOLDEN, SILVER, CLASSIC), active campaigns, and item prices
        // Replace the following return statement with your logic
        return 0.0;
    }

    // Helper method to process the order and give feedback
    private void processOrder(double totalPrice) {
        // Implement the logic to process the order and give feedback
        // You need to consider customer status, balance update, and feedback messages
        // Replace the following print statements with your logic
        System.out.println("Congratulations! Your order will be delivered as soon as possible. Thank you!");
        System.out.println("Congratulations! You have been upgraded to a XXX MEMBER! You have earned a discount of X% on all purchases.");
        System.out.println("You need to spend XXX more TL to become a XXX MEMBER.");
    }

}