package task.dog.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dog {

//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;

        //lets Spring know this is an entity class and will let Spring create a table for us directly from here

            //ID column, auto generates with @GeneratedValue
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private long id;

            @Column
            private int age;

            //unique name, CANT be null
            @Column(unique = true, nullable = false)
            private  String name;

            @Column
            private  String breed;

            @Column
            private String gender;

            //Default constructor
            public Dog() {}

            //For creating Dogs
    public Dog(int age, String name, String breed, String gender) {
        this.age = age;
        this.name = name;
        this.breed = breed;
        this.gender = gender;
    }


    //For testing
    public Dog(long id, int age, String breed,  String gender, String name) {
        this.id = id;
        this.age = age;
        this.breed = breed;
        this.gender = gender;
        this.name = name;

    }

    public Dog(int id, int age,  String breed, String gender,String name) {
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

            public String getBreed() {
            return breed;
            }

            public void setBreed(String breed) {
            this.breed = breed;
            }

            public String getGender() {
            return gender;
            }

            public void setGender(String gender) {
            this.gender = gender;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "Dog [id=" + id + ", age=" + age + ",  breed=" + breed + ",gender= "+ gender + ",name=" + name
                        + "]";
            }


            //More for testing when comparing objects match
            @Override
            public int hashCode() {
                return Objects.hash(age,breed,gender,name);
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
                Dog other = (Dog) obj;
                return age == other.age && Objects.equals (breed, other.breed) && Objects.equals(gender, other.gender) && Objects.equals(name, other.name);

            }
        }

