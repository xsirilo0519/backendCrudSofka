package co.com.sofka.crud.services;

import co.com.sofka.crud.Enities.Todo;
import co.com.sofka.crud.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public Iterable<Todo> list(){
        return todoRepository.findAll();
    }
    public Todo save(Todo todo){
        return todoRepository.save(todo);
    }
    public void delete(Long id){
        todoRepository.delete(get(id));
    }
    public Todo get(Long id){
        return todoRepository.findById(id).orElseThrow();
    }
}
