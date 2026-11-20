package bookreview;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

// Week 9, stretch: the whole list of books as bytes, with Java serialization.
public final class BookSnapshot {

    private BookSnapshot() {
    }

    public static void save(List<Book> books, Path file) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(file))) {
            out.writeObject(new ArrayList<>(books));
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Book> load(Path file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(file))) {
            return (List<Book>) in.readObject();
        }
    }
}
