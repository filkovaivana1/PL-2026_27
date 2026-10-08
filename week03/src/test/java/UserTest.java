import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

// Task 1. The class User does not exist yet, so this file is red in the editor.
// Create src/main/java/User.java until these tests compile and pass.
class UserTest {

    @Test
    void constructorStoresTheValues() {
        User ana = new User("ana", "ana@example.com");
        assertEquals("ana", ana.getUsername());
        assertEquals("ana@example.com", ana.getEmail());
    }

    @Test
    void setEmailAcceptsOnlyTextWithAnAtSign() {
        User ana = new User("ana", "ana@example.com");
        ana.setEmail("not an email");
        assertEquals("ana@example.com", ana.getEmail());
        ana.setEmail("ana@uacs.example");
        assertEquals("ana@uacs.example", ana.getEmail());
    }

    @Test
    void constructorUsesTheSameRule() {
        User broken = new User("marko", "no at sign");
        assertEquals(null, broken.getEmail());
    }

    @Test
    void toStringShowsNameAndEmail() {
        User ana = new User("ana", "ana@example.com");
        assertEquals("ana (ana@example.com)", ana.toString());
    }
}
