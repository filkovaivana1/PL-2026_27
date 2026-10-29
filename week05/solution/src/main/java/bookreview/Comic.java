package bookreview;

// Stretch: a comic is a printed book with one more property.
public class Comic extends PrintedBook {
    private boolean colour;

        public Comic(String title, String author, int year, int pages, boolean colour) {
        super(title, author, "Comic", year, pages);
        this.colour = colour;
    }

    public boolean isColour() {
        return colour;
    }

    @Override
    public String format() {
        return "comic";
    }

    @Override
    public String sizeInfo() {
        if (colour) {
            return super.sizeInfo() + ", colour";
        }
        return super.sizeInfo() + ", black and white";
    }
}
