package com.congo.todo.service;

import com.congo.todo.entity.Todo;

import java.util.List;

public interface TodoService {

    List<Todo>getAllTodo();//get all the item in the data
    void saveTodo(Todo todo);//expect something

    void updateTodo(Long id,Todo todo);//creating an entity based on the method for creating a new object
    Todo getTodoById(Long id);// fetching the data by id
    void deleteTodo(Long id);//deleting a list
}

