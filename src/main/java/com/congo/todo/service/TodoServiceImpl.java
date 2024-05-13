package com.congo.todo.service;

import com.congo.todo.entity.Todo;
import com.congo.todo.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {//implementing the method we have
//because we want to use method from db we need to connect
   @Autowired//if you want to use a class in another class, it tells what information it wants to use
    private TodoRepo todoRepo;
   @Override//method we have in the service and reusing ni our implementation
    public List<Todo>getAllTodo(){
       return todoRepo.findAll();// method that are provided by jpa as it allows communication between application database
   }
   @Override
    public void saveTodo(Todo todo){
       this.todoRepo.save(todo);//getting a method from another class
   }
   @Override
    public Todo getTodoById(Long id){
       Optional<Todo> optional=todoRepo.findById(id);
       Todo todo;
       if(optional.isPresent()){
           todo=optional.get();
       } else{
           throw new RuntimeException("Todo for the id"+id+"is not found");
       }
       return todo;
   }

   @Override
    public void updateTodo(Long id, Todo todo){
      Todo todoFromDb = todoRepo.findById(id).get();
      todoFromDb.setTaskName(todo.getTaskName());
      todoFromDb.setDesc(todo.getDesc());
      todoRepo.save(todoFromDb);
   }

   @Override
    public  void deleteTodo(Long id){
  this.todoRepo.deleteById(id);
   }
}
