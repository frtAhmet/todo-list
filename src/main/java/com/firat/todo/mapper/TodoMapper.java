package com.firat.todo.mapper;

import com.firat.todo.dto.TodoDto;
import com.firat.todo.entity.Todo;

public class TodoMapper {

    public static TodoDto mapTodoEntityToDto(Todo todo) {

        return new TodoDto(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.isCompleted()
        );
    }

    public static Todo mapTodoDtoToEntity(TodoDto todoDto) {
        return new Todo(
                todoDto.getId(),
                todoDto.getTitle(),
                todoDto.getDescription(),
                todoDto.isCompleted()
        );
    }

//    public Todo mapTodoDtoToEntity(TodoDto todoDto) {
//
//        Todo todo = new Todo();
//        todo.setTitle(todoDto.getTitle());
//        todo.setDescription(todoDto.getDescription());
//        todo.setCompleted(todoDto.isCompleted());
//
//        return todo;
//    }
}
