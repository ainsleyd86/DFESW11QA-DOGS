package task.dog.service;

import java.util.List;

public interface ServiceMethods<T> {

    //Create
    T create(T dog);

    //Read All
    List<T> readAll();

    //Read By Id
    T readById(long id);

    //Update
    T update(long id, T dog);

    //Delete
    boolean delete(long id);
}