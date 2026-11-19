package bookreview;

// Task 3: one book as one line of text, and back.
// Format: kind;title;author;genre;year;size
// Examples: printed;Emma;Jane Austen;Classic;1815;474
//           ebook;Dune;Frank Herbert;Science fiction;1965;1.4
//           audio;Persuasion;Jane Austen;Classic;1817;510
public final class BookLines {

    private BookLines() {
    }

    // The kind is book.format(). The size is the pages, the megabytes or the minutes.
    public static String toLine(Book book) {
        return ""; // TODO
    }

    // Split at ";". Not exactly 6 parts: throw an IllegalArgumentException.
    // Unknown kind: throw an IllegalArgumentException. Create the right subclass.
    public static Book fromLine(String line) {
        return null; // TODO
    }
}
