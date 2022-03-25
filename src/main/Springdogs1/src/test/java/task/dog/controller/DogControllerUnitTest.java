package task.dog.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import task.dog.controller.DogController;
import task.dog.entity.Dog;
import task.dog.service.DogService;

@SpringBootTest
public class DogControllerUnitTest {

    @Autowired
    private DogController controller;

    @MockBean
    private DogService service;

    @Test
    public void createDuckTest() {
        Dog dog = new Dog(10,15, "XLBully", "Male", "Zeus");

        Mockito.when(this.service.create(dog)).thenReturn(dog);

        ResponseEntity<Dog> response = new ResponseEntity<Dog>(dog, HttpStatus.CREATED);

        assertThat(response).isEqualTo(this.controller.createDog(dog));

        Mockito.verify(this.service, times(1)).create(dog);
    }
}
