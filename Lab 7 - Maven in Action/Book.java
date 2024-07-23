import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Book {
    private static final Log LOGGER = LogFactory.getLog(Book.class);

    private String title;
    private String location;
    private boolean borrowable;

    public Book(String title, String location, boolean borrowable) {
        this.title = title;
        this.location = location;
        this.borrowable = borrowable;
        LOGGER.info("Title: " + title + ", Location: " + location + ", Borrowable: " + borrowable);
    }

    public static void main(String[] args) {
        Book book = new Book("The Great Gatsby", "Third Floor", true);
    }
}
