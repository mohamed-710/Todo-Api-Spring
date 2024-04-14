package com.mode.Todo.todos;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping(value="/api/v1/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping(value = {"", "/"})
    public List<Todo> getAllTodos()
    {
        return todoService.findAll();
    }
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable  String id)
    {
        return todoService.getById(id);
    }
    @PostMapping(value={"","/"})
    public Todo createNewTodo(@RequestBody Todo todo)
    {
   return todoService.save(todo);
    }
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable String id)
    {
        todoService.delete(id);
    }
}