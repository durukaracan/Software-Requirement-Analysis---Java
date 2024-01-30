// OfficeSuppliesItem class (inherits from Item)
class OfficeSuppliesItem extends Item {
    private String releaseDate;
    private String coverTitle;

    public OfficeSuppliesItem(double price, int stock, String releaseDate, String coverTitle) {
        super(price, stock);
        this.releaseDate = releaseDate;
        this.coverTitle = coverTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getCoverTitle() {
        return coverTitle;
    }
// Other methods specific to OfficeSuppliesItem can be added


}

