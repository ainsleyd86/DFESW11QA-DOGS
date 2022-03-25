package task.dog.service;


import task.dog.entity.Dog;
import task.dog.repo.DogRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DogService implements ServiceMethods<Dog> {

    //NOT making a new object, creating a variable of the type DuckRepo
    private DogRepo repo;

    //Above is different to this, as we are trying to instantiate an object below (Cannot instantiate an interface)
    //DuckRepo repo = new DuckRepo();

    //Constructor
    public DogService(DogRepo repo) {
        this.repo = repo;
    }

    @Override
    public Dog create(Dog dog) {
        return this.repo.save(dog);
    }

    @Override
    public List<Dog> readAll() {
        return this.repo.findAll();
    }

    @Override
    public Dog readById(long id) {
        Optional<Dog> getDog = this.repo.findById(id);
        if (getDog.isPresent()) {
            return getDog.get();
        }
        return null;
    }

    //When setting values, DO NOT set the id
    @Override
    public Dog update(long id, Dog dog) {
        Optional<Dog> existingDog = this.repo.findById(id);
        if (existingDog.isPresent()) {
            Dog exists = existingDog.get();
            exists.setAge(dog.getAge());
            exists.setName(dog.getName());
            exists.setBreed(dog.getBreed());
            exists.setGender(dog.getGender());


            return this.repo.saveAndFlush(exists);
        }
        return null;
    }

    //Deletes the id, and checks to see if it still exists (should return true if it has worked)
    @Override
    public boolean delete(long id) {
        this.repo.deleteById(id);
        return !this.repo.existsById(id);
    }
}
