import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

// Campaign class
class Campaign {
    private static List<Campaign> activeCampaigns = new ArrayList<>();
    private static int campaignCounter = 1;
    public static final double MAX_DISCOUNT_RATE = 50.0;

    private int campaignID;
    private Date startDate;
    private Date endDate;
    private String itemType;
    private double discountRate;

    public Campaign(String startDate, String endDate, String itemType, double discountRate) {
        this.campaignID = campaignCounter++;
        try {
            this.startDate = new SimpleDateFormat("dd.MM.yyyy").parse(startDate);
            this.endDate = new SimpleDateFormat("dd.MM.yyyy").parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();  // Handle the exception based on your needs
        }
        this.itemType = itemType;
        this.discountRate = validateDiscountRate(discountRate);

        // Add the campaign to the list of active campaigns
        activeCampaigns.add(this);
    }

    private double validateDiscountRate(double discountRate) {
        // Ensure discount rate does not exceed the maximum allowed
        return Math.min(discountRate, MAX_DISCOUNT_RATE);
    }

    public String getItemType() {
        return itemType;
    }

    public static List<Campaign> getActiveCampaigns() {
        return activeCampaigns;
    }

    // Other methods related to Campaign can be added

    public static int getCampaignCounter() {
        return campaignCounter;
    }

    public int getCampaignID() {
        return campaignID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}
