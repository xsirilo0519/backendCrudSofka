package co.com.sofka.crud.controllers;

import co.com.sofka.crud.Enities.Todo;
import co.com.sofka.crud.repositories.TodoRepository;
import co.com.sofka.crud.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @GetMapping(value = "api/todos")
    public ResponseEntity<?> list(){
        return new ResponseEntity(todoService.list(), HttpStatus.OK);
    }

    @PostMapping(value = "api/todo")
    public Todo save(@RequestBody Todo todo){
        return todoService.save(todo);
    }

    @PutMapping(value = "api/todo")
    public Todo update(@RequestBody Todo todo){
        if (todo.getId()!=null){
            return todoService.save(todo);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }
    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id") Long id){
        todoService.delete(id);
    }
    @GetMapping(value = "api/{id}/todo")
    public Todo get(@PathVariable("id") Long id){
        return todoService.get(id);
    }
}
