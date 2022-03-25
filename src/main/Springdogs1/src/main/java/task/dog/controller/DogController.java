package task.dog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task.dog.entity.Dog;
import task.dog.service.DogService;
import java.util.List;

@RestController
@RequestMapping("/dog")
public class DogController {

    private DogService service;

    @Autowired // instructs Spring to insert the DogService object
    public DogController(DogService service) {
        this.service = service;
    }

    @PostMapping("/create")

    public ResponseEntity<Dog> createDog(@RequestBody Dog dog) {
        // @RequestBody allows us to pass through an object/data when we make the request
        return new ResponseEntity<Dog>(this.service.create(dog), HttpStatus.CREATED);
    }

    @GetMapping("/readAll")
    public ResponseEntity<List<Dog>> readAllDogs() {
        // We return a list because the readAll method in the service class returns a list
        return new ResponseEntity<List<Dog>>(this.service.readAll(), HttpStatus.OK);
    }

    @GetMapping("/readById/{id}")
    // @PathVariable allows us to pass a variable (in this case ID) to the path & service.readById method
    public ResponseEntity<Dog> readById(@PathVariable long id) {
        return new ResponseEntity<Dog>(this.service.readById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    // update requires both RequestBody and PathVariable as it takes in the id, and
    // also passes through the new object information
    public ResponseEntity<Dog> updateDuck(@PathVariable long id, @RequestBody Dog dog) {
        return new ResponseEntity<Dog>(this.service.update(id, dog), HttpStatus.ACCEPTED);
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDog(@PathVariable long id) {
        // Ternary operator, IF service.delete goes through (deletes the id), return no
        // content, ELSE return not found
        return (this.service.delete(id)) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*
     * This is the same as above, but written using if/else statements
     * if(this.service.delete(id) == true) { new
     * ResponseEntity<Boolean>(HttpStatus.NO_CONTENT) } else { new
     * ResponseEntity<Boolean>(HttpStatus.NOT_FOUND) }
     */
}


