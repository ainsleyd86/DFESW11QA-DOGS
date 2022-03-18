package task.dog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import task.dog.entity.Dog;

@Repository
public interface DogRepo extends JpaRepository <Dog, Long>{

    }

