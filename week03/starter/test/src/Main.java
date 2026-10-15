//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main(String[] args) {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    Book[] shelf = new Book[2];
    shelf[0] = new Book("Title1", "Author 1", "Science fiction", 1450);
    shelf[1] = new Book("Title2", "Author 2", "Science fiction", 1450);

    System.out.println("Current books: " + Book.getCreatedCount());
    for (Book book : shelf) {
        if (book != null) {
            System.out.println(book);
        }
    }

    System.out.println("Oldest book: " + CatalogTools.oldestBook(shelf));

    if (args.length > 0) {
        String genre = args[0];
        System.out.println(genre + ": " + CatalogTools.countByGenre(shelf,genre));
    }


}
