import java.util.Date;
import java.util.List;

// Order class
class Order {
    private static int orderCounter = 1;

    private int orderID;
    private Date orderDate;
    private double totalCost;
    private List<Item> purchasedItems;
    private int customerID;

    public Order(double totalCost, List<Item> purchasedItems, int customerID) {
        this.orderID = orderCounter++;
        this.orderDate = new Date(); // Assuming order date is set to the current date and time
        this.totalCost = totalCost;
        this.purchasedItems = purchasedItems;
        this.customerID = customerID;
    }

    public void displayOrderData() {
        System.out.println("Order ID: " + orderID);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Customer ID: " + customerID);
        System.out.println("Total Cost: $" + totalCost);
        System.out.println("Number of Bought Items: " + purchasedItems.size());
    }

    public int getOrderID() {
        return orderID;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public static int getOrderCounter() {
        return orderCounter;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public List<Item> getPurchasedItems() {
        return purchasedItems;
    }

    public int getCustomerID() {
        return customerID;
    }
}
