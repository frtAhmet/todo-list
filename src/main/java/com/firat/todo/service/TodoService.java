package com.firat.todo.service;


import com.firat.todo.dto.TodoDto;

import java.util.List;

public interface TodoService {

    TodoDto addTodo(TodoDto todoDto);

    TodoDto getTodo(Long id);

    List<TodoDto> getAllTodos();

    TodoDto updateTodo(Long id, TodoDto todoDto);

    void deleteTodo(Long id);

    TodoDto completeTodo(Long id);

    TodoDto incompleteTodo(Long id);
}
