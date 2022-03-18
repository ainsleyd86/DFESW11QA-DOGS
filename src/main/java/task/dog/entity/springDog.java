package task.dog.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class springDog {



//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;

        //lets Spring know this is an entity class and will let Spring create a table for us directly from here

            //ID column, auto generates with @GeneratedValue
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private long id;

            //Min = minimum number allowed, Max = maximum number allowed
            @Column
     /*   @Min(1)
        @Max(15)*/
            private int age;

            //unique name, CANT be null
            @Column(unique = true, nullable = false)
            private String name;

            @Column
            private String breed;

            @Column
            private String weight;

            @Column
            private String gender;

            //Default constructor
            public springDog() {}

            //For creating Dogs

    public springDog(int age, String name, String breed, String weight, String gender) {
        this.age = age;
        this.name = name;
        this.breed = breed;
        this.weight = weight;
        this.gender = gender;
    }


    //For testing

    public springDog(long id, int age, String name, String breed, String weight, String gender) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.breed = breed;
        this.weight = weight;
        this.gender = gender;
    }

    //Getters and Setters
            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getBreed() {
                return breed;
            }

            public void setBreed(String breed) {
                this.breed = breed;
            }

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            @Override
            public String toString() {
                return "Dog [id=" + id + ", age=" + age + ", name=" + name + ", breed=" + breed + weight + ",gender"
                        + "]";
            }


            //More for testing when comparing objects match
            @Override
            public int hashCode() {
                return Objects.hash(age, name, breed ,weight, gender);
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null) {
                    return false;
                }
                if (getClass() != obj.getClass()) {
                    return false;
                }
                springDog other = (springDog) obj;
                return age == other.age && Objects.equals(name, other.name) && Objects.equals(breed, other.breed) && Objects.equals(weight, other.weight) && Objects.equals(gender, other.gender);

            }
        }

