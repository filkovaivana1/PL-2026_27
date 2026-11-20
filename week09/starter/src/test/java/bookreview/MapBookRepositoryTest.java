package bookreview;

// From week 8. The very same tests, now against MapBookRepository.
class MapBookRepositoryTest extends BookRepositoryContract {

    @Override
    protected BookRepository createRepository() {
        return new MapBookRepository();
    }
}
