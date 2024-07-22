package com.firat.todo.service.impl;

import com.firat.todo.dto.TodoDto;
import com.firat.todo.entity.Todo;
import com.firat.todo.exception.ResourceNotFoundException;
import com.firat.todo.mapper.TodoMapper;
import com.firat.todo.repository.TodoRepository;
import com.firat.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        Todo todo = TodoMapper.mapTodoDtoToEntity(todoDto);

        Todo savedTodo = todoRepository.save(todo);

        return TodoMapper.mapTodoEntityToDto(savedTodo);
    }

    @Override
    public TodoDto getTodo(Long id) {

        Todo todo = todoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Todo not found with id : " + id));

        return TodoMapper.mapTodoEntityToDto(todo);
    }

    @Override
    public List<TodoDto> getAllTodos() {

        List<Todo> todos = todoRepository.findAll();

        return todos.stream().map(TodoMapper::mapTodoEntityToDto)
                .collect(Collectors.toList());

    }

    @Override
    public TodoDto updateTodo(Long id, TodoDto todoDto) {

        Todo todo = todoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Todo not found with id : " + id));

        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        Todo updateTodo = todoRepository.save(todo);

        return TodoMapper.mapTodoEntityToDto(updateTodo);
    }

    @Override
    public void deleteTodo(Long id) {

        Todo todo = todoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Todo not found with id : " + id));

        todoRepository.deleteById(todo.getId());
    }

    @Override
    public TodoDto completeTodo(Long id) {

        Todo todo = todoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Todo not found with id : " + id));

        todo.setCompleted(Boolean.TRUE);

        Todo updatedTodo = todoRepository.save(todo);

        return TodoMapper.mapTodoEntityToDto(updatedTodo);
    }

    @Override
    public TodoDto incompleteTodo(Long id) {

        Todo todo = todoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Todo not found with id : " + id));

        todo.setCompleted(Boolean.FALSE);

        Todo updatedTodo = todoRepository.save(todo);

        return TodoMapper.mapTodoEntityToDto(updatedTodo);
    }
}
