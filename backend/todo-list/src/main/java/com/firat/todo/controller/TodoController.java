package com.firat.todo.controller;

import com.firat.todo.dto.TodoDto;
import com.firat.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto) {

        TodoDto savedTodo = todoService.addTodo(todoDto);

        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long todoId) {

        TodoDto todoDto = todoService.getTodo(todoId);

        return ResponseEntity.ok(todoDto);
    }

    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos() {

        List<TodoDto> todoList = todoService.getAllTodos();

        return ResponseEntity.ok(todoList);
    }

    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable("id") Long todoId,
                                              @RequestBody TodoDto todoDto) {

        TodoDto updatedTodo = todoService.updateTodo(todoId, todoDto);

        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId) {

        todoService.deleteTodo(todoId);

        return ResponseEntity.ok("Todo deleted successfully!");
    }

    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDto> completeTodo(@PathVariable("id") Long todoId) {

        TodoDto completedTodo = todoService.completeTodo(todoId);

        return ResponseEntity.ok(completedTodo);
    }

    @PatchMapping("{id}/in-complete")
    public ResponseEntity<TodoDto> inCompleteTodo(@PathVariable("id") Long todoId) {

        TodoDto inCompletedTodo = todoService.incompleteTodo(todoId);

        return ResponseEntity.ok(inCompletedTodo);
    }
}
