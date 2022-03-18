package task.dog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public class DogRepo {

import task.dog.entity.springDog;


    public interface DogRepo extends JpaRepository <, Long>{

    }
}
