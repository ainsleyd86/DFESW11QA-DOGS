package task.dog.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import task.dog.entity.Dog;
import task.dog.repo.DogRepo;

@SpringBootTest
public class DogServiceUnitTest {

    // tells Spring to insert this object into the class
    @Autowired
    private DogService service;

    // mocking the repository class as we dont want to rely on the class itself
    @MockBean
    private DogRepo repo;

    @Test
    public void createDuckTest() {
        Dog input = new Dog(3,3, "Pommy", "Female", "Polly");
        Dog output = new Dog(3, 3, "Pommy", "Female", "Polly");

        // Here we are testing the actual method (within the create method in the
        // DuckService class)
        Mockito.when(this.repo.save(input)).thenReturn(output);

        // Here we are checking the expected value (output) is the same as the actual
        // value that gets output when we run the create method in service
        assertEquals(output, this.service.create(input));

        //Verifies that the repo is run 1 time, and saves the input
        Mockito.verify(this.repo, Mockito.times(1)).save(input);
    }

    @Test
    public void readByIdTest() {
        //Here we are using an optional because we use it in the readById() method in the DogService class
        Optional<Dog> optionalOutput = Optional.of(new Dog(3, 3, "Pommy", "Female", "Polly"));
        Dog output = new Dog(3, 3, "Pommy", "Female", "Polly");

        //Mockito.anyLong() checks that the type of data that we use is a Long, no matter what the number
        Mockito.when(this.repo.findById(Mockito.anyLong())).thenReturn(optionalOutput);

        assertEquals(output, this.service.readById(Mockito.anyLong()));

        Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyLong());
    }


    @Test
    public void deleteTrueTest() {
        Mockito.when(this.repo.existsById(1L)).thenReturn(false);

        assertTrue(this.service.delete(1L));

        Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
        Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
    }
}
