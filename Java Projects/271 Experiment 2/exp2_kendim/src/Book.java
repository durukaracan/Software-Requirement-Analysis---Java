// Book class (inherits from OfficeSuppliesItem)
class Book extends OfficeSuppliesItem {
    private String publisher;
    private String authors;
    private int numberOfPages;
   private String coverTitle;

    public Book(double price, int stock, String releaseDate, String coverTitle,
                String publisher, String authors, int numberOfPages) {
        super(price, stock, releaseDate, coverTitle);
        this.publisher = publisher;
        this.authors = authors;
        this.numberOfPages = numberOfPages;
    }

    // Other methods specific to Book can be added
    public String getCoverTitle() {

        return coverTitle;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAuthors() {
        return authors;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }


}