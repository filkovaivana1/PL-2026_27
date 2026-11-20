package bookreview;

// Week 9, task 3: one book as one line of text, and back.
// Format: kind;title;author;genre;year;size
// Examples: printed;Emma;Jane Austen;Classic;1815;474
//           ebook;Dune;Frank Herbert;Science fiction;1965;1.4
public final class BookLines {

    private BookLines() {
    }

    public static String toLine(Book book) {
        String size;
        if (book instanceof PrintedBook printed) {
            size = String.valueOf(printed.getPages());
        } else if (book instanceof EBook ebook) {
            size = String.valueOf(ebook.getMegabytes());
        } else if (book instanceof AudioBook audio) {
            size = String.valueOf(audio.getMinutes());
        } else {
            throw new IllegalArgumentException("Unknown kind of book: " + book.format());
        }
        return book.format() + ";" + book.getTitle() + ";" + book.getAuthor() + ";"
                + book.getGenre() + ";" + book.getYear() + ";" + size;
    }

    // Throws IllegalArgumentException for a line that is not six parts or has an unknown kind.
    // A number that cannot be parsed throws NumberFormatException, which is an IllegalArgumentException too.
    public static Book fromLine(String line) {
        String[] p = line.split(";");
        if (p.length != 6) {
            throw new IllegalArgumentException("Expected 6 parts, found " + p.length + ": " + line);
        }
        int year = Integer.parseInt(p[4]);
        return switch (p[0]) {
            case "printed" -> new PrintedBook(p[1], p[2], p[3], year, Integer.parseInt(p[5]));
            case "ebook" -> new EBook(p[1], p[2], p[3], year, Double.parseDouble(p[5]));
            case "audio" -> new AudioBook(p[1], p[2], p[3], year, Integer.parseInt(p[5]));
            default -> throw new IllegalArgumentException("Unknown kind: " + p[0]);
        };
    }
}
