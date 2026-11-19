package bookreview;

// One review. A record: plain data that never changes.
public record Review(User user, Book book, int rating, String text) {
    public Review {
        if (rating < 1) {
            rating = 1;
        }
        if (rating > 5) {
            rating = 5;
        }
        if (text == null) {
            text = "";
        }
    }
}
