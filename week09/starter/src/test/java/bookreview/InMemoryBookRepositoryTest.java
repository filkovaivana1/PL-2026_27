package bookreview;

// From week 8. Runs all tests of BookRepositoryContract against InMemoryBookRepository.
class InMemoryBookRepositoryTest extends BookRepositoryContract {

    @Override
    protected BookRepository createRepository() {
        return new InMemoryBookRepository();
    }
}
