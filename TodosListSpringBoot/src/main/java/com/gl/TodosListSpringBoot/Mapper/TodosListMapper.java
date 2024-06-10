package com.gl.TodosListSpringBoot.Mapper;

import com.gl.TodosListSpringBoot.Model.TodosList;
import com.gl.TodosListSpringBoot.dto.TodosListDto;

public class TodosListMapper {
	//convert todo jpa entity into todo dto
	public static TodosListDto mapToTodosListDto(TodosList todosList) {
		return new TodosListDto(
				todosList.getId(),
				todosList.getTodoTitle(),
				todosList.getTodoDescription(),
				todosList.getTodoCompleted()
				);
	}
	//convert todo dto into todo jpa entity
	public static TodosList mapToTodosList(TodosListDto todosListDto) {
		return new TodosList(
				todosListDto.getId(),
				todosListDto.getTodoTitle(),
				todosListDto.getTodoDescription(),
				todosListDto.getTodoCompleted()
				);
				
	}

}
