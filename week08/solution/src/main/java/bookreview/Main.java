package bookreview;

// Week 8 demo: the same service works with two different repositories.
public class Main {
    public static void main(String[] args) {
        BookRepository[] repositories = { new InMemoryBookRepository(), new MapBookRepository() };

        for (BookRepository repository : repositories) {
            Book persuasion = new AudioBook("Persuasion", "Jane Austen", "Classic", 1817, 510);
            Book emma = new PrintedBook("Emma", "Jane Austen", "Classic", 1815, 474);
            repository.add(persuasion);
            repository.add(emma);
            repository.add(new EBook("Dune", "Frank Herbert", "Science fiction", 1965, 1.4));
            repository.add(new PrintedBook("Emma", "Jane Austen", "Classic", 1815, 474));

            ReviewService service = new ReviewService(repository);
            User ana = new User("ana", "ana@uacs.edu.mk");
            service.addReview(ana, emma.getId(), 5, "Loved it");
            service.addReview(ana, emma.getId(), 4, "Still good the second time");
            boolean unknown = service.addReview(ana, 9999, 3, "No such book");

            System.out.println(repository.getClass().getSimpleName() + ": " + repository.count() + " books");
            System.out.println("  Review for book 9999 accepted? " + unknown);
            System.out.println("  Average for Emma: " + service.averageRating(emma.getId()));
            for (Book book : service.booksByAuthorSorted("jane austen")) {
                System.out.println("  " + book.getTitle() + " (" + book.getYear() + ")");
            }
        }
    }
}
