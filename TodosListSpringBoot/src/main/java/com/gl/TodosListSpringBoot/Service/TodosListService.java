package com.gl.TodosListSpringBoot.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.TodosListSpringBoot.Mapper.TodosListMapper;
import com.gl.TodosListSpringBoot.Model.TodosList;
import com.gl.TodosListSpringBoot.Repository.TodosListRepository;
import com.gl.TodosListSpringBoot.dto.TodosListDto;


import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class TodosListService {
	@Autowired
	private TodosListRepository todosListRepository;
	
	public TodosListDto createTodosList(TodosListDto todosListDto) {
		TodosList todosList = TodosListMapper.mapToTodosList(todosListDto);
		TodosList savedTodosList= todosListRepository.save(todosList);
		return TodosListMapper.mapToTodosListDto(savedTodosList);
	}
	
	public TodosListDto getTodosListById(Long todosListId) {
		Optional<TodosList> opt = todosListRepository.findById(todosListId);
		if(opt.get() != null) {
			TodosList todosList = opt.get();
			return TodosListMapper.mapToTodosListDto(todosList);
		}
		return null;
	}
	
	public List<TodosListDto> getAllTodosList(){
		List<TodosList> todosLists = todosListRepository.findAll();
		return todosLists.stream().map((todosList) -> 
		TodosListMapper.mapToTodosListDto(todosList)).collect(Collectors.toList());		
	}
	
	public TodosListDto updateTodosList(Long todosListId, TodosListDto updateTodosList) {
		Optional<TodosList> opt=todosListRepository.findById(todosListId);
		
		TodosList todosList = null;
		if(opt.get() != null) {
			todosList = opt.get();
			todosList.setTodoTitle(updateTodosList.getTodoTitle());
			todosList.setTodoDescription(updateTodosList.getTodoDescription());
			todosList.setTodoCompleted(updateTodosList.getTodoCompleted());
			
			TodosList saveTodosList = todosListRepository.save(todosList);
			
			return TodosListMapper.mapToTodosListDto(saveTodosList);
		}
		return null;
	}
	
	public void deleteTodosList(Long todosListId) {
		todosListRepository.deleteById(todosListId);
	}

}
