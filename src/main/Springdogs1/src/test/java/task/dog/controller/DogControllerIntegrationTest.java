package task.dog.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import task.dog.entity.Dog;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // creates the MockMVC object
@ActiveProfiles("test") // sets current profile to 'test'
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = { "classpath:dog-schema.sql, classpath:dog-data.sql "})

public class DogControllerIntegrationTest {

    @Autowired // tells Spring to insert this object into the class
    private MockMvc mvc; // object for running fake requests

    @Autowired
    private ObjectMapper mapper; // the object Spring uses to convert JSON <-> Java

    @Test
    public void test() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testCreate() throws Exception {
        // URL body method headers
        Dog testDog = new Dog(5, "Yorky", "Female", "Yvonne");
        String testDogAsJSON = this.mapper.writeValueAsString(testDog);
        RequestBuilder req = post("/dog/create").content(testDogAsJSON).contentType(MediaType.APPLICATION_JSON);

        Dog testSavedDog = new Dog(1, 5, "Yorky", "Female", "Yvonne");
        String testSavedDogAsJSON = this.mapper.writeValueAsString(testSavedDog);
        // this will check the status code of my response
        ResultMatcher checkStatus = status().isCreated();
        // this will check the body of the response
        ResultMatcher checkBody = (ResultMatcher) content().json(testDogAsJSON);

        // run the request and check both matchers
        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }

    @Test
    public void testCreate2() throws Exception {
        // URL body method headers
        Dog testDog = new Dog( 15, "Shih Tzu", "Male", "Goliath");
        String testDogAsJSON = this.mapper.writeValueAsString(testDog);
        RequestBuilder req = post("/dog/create").content(testDogAsJSON).contentType(MediaType.APPLICATION_JSON);

        Dog testSavedDog = new Dog(2, 15, "Shih Tzu", "Male", "Goliath");
        String testSavedDogAsJSON = this.mapper.writeValueAsString(testSavedDog);
        // this will check the status code of my response
        ResultMatcher checkStatus = status().isCreated();
        // this will check the body of the response
        ResultMatcher checkBody = (ResultMatcher) content().json(testSavedDogAsJSON);

        // run the request and check both matchers
        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }

    @Test
    public void testReadById() throws Exception {
        RequestBuilder req = get("/dog/readById/3");

        ResultMatcher checkStatus = status().isOk();

        Dog savedDog = new Dog(3, 3, "Pommy", "Female", "Polly");
        String savedDogAsJSON = this.mapper.writeValueAsString(savedDog);

        ResultMatcher checkBody = (ResultMatcher) content().json(savedDogAsJSON);

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }

    @Test
    public void testReadAll() throws Exception {
        Dog entry = new Dog(3L, 3, "Pommy", "Female", "Polly");
        List<Dog> dogs = new ArrayList<>();
        dogs.add(entry);
        String dogsOutputAsJson = this.mapper.writeValueAsString(dogs);

        this.mvc.perform(get("/dog/readAll")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(dogsOutputAsJson));
    }

   /* @Test
    public void updateTest() throws Exception{
        Dog entry = new Dog(3L, 3, "Pommy", "Female", "Polly");
        String entryDuckAsJson = this.mapper.writeValueAsString(entry);

        Dog result = new Dog(3L, 3, "Pommy", "Female", "Polly");
        String resultDogAsJson = this.mapper.writeValueAsString(result);

        this.mvc.perform(put("/dog/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(entryDogAsJSON))
                .andExpect(status().isAccepted())
                .andExpect(content().json(resultDogAsJson));*/
    }




