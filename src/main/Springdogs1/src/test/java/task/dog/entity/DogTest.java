package task.dog.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class DogTest {

    // Remember to import the equalsverifier dependency
    @Test
    public void testEquals() {
        EqualsVerifier.forClass(Dog.class).usingGetClass().verify();
    }

    @Test
    public void getAndSetTest() {

        // Create empty dog object
        Dog dog = new Dog();

        // Use the setter methods to add values to each field, so we can check the
        // setters work
        dog.setId(1);
        dog.setAge(5);
        dog.setBreed("Yorky");
        dog.setGender("Female");
        dog.setName("Yvonne");

        // make sure after the setters, they actually set the values and are not null
        assertNotNull(dog.getId());
        assertNotNull(dog.getAge());
        assertNotNull(dog.getBreed());
        assertNotNull(dog.getGender());
        assertNotNull(dog.getName());

        // make sure that when we use the getters, they get the correct value
        assertEquals(dog.getId(), 1);
        assertEquals(dog.getAge(), 5);
        assertEquals(dog.getBreed(), "Yorky");
        assertEquals(dog.getGender(), "Female");
        assertEquals(dog.getName(), "Yvonne");
    }

    @Test
    public void allArgsConstructor() {
        Dog dog = new Dog(3, 3, "Pommy", "Female", "Polly");

        // make sure after the setters, they actually set the values and are not null
        assertNotNull(dog.getId());
        assertNotNull(dog.getAge());
        assertNotNull(dog.getBreed());
        assertNotNull(dog.getGender());
        assertNotNull(dog.getName());

        // make sure that when we use the getters, they get the correct value
        assertEquals(dog.getId(), 3);
        assertEquals(dog.getAge(), 3);
        assertEquals(dog.getBreed(), "Pommy");
        assertEquals(dog.getGender(), "Female");
        assertEquals(dog.getName(), "Polly");
    }

}

