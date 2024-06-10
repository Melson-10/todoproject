package com.gl.TodosListSpringBoot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.TodosListSpringBoot.Service.TodosListService;
import com.gl.TodosListSpringBoot.dto.TodosListDto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/api/todosLists")
public class TodosListController {

	@Autowired
	private TodosListService todosListService;
	
	//Build create or Add todosList REST API
	@PostMapping
	public ResponseEntity<TodosListDto> createTodosList(@RequestBody TodosListDto todosListDto){
		TodosListDto todosList = todosListService.createTodosList(todosListDto);
		return new ResponseEntity<>(todosList,HttpStatus.CREATED);
	}
	
	//Build Get todosList REST API
	@GetMapping("{id}")  //api/todosLists/id
	public ResponseEntity<TodosListDto> getTodosListById(@PathVariable("id") Long todosListId){
		TodosListDto todosListDto = todosListService.getTodosListById(todosListId);
		return ResponseEntity.ok(todosListDto);
	}
	
	//Build Get all todosList rest api
	@GetMapping //api/todosLists
	public ResponseEntity<List<TodosListDto>> getAllTodosList(){
		List<TodosListDto> todosLists = todosListService.getAllTodosList(); ///s
		return ResponseEntity.ok(todosLists);
	}
	
	//build update todosLists rest api
	@PutMapping("{id}") ///api/todosLists/id
	public ResponseEntity<TodosListDto> updateDepartment(@PathVariable("id") Long todosListId,@RequestBody TodosListDto updatedTodosList){
		TodosListDto todosListDto = todosListService.updateTodosList(todosListId, updatedTodosList);
		return ResponseEntity.ok(todosListDto);
	}
	
	//build delete todosLists rest api
	@DeleteMapping("{id}") ///api/todosLists/id
	public ResponseEntity<String> deleteTodosLists(@PathVariable("id") Long todosListId){
		todosListService.deleteTodosList(todosListId);
		return ResponseEntity.ok("TodosList deleted successfully");
	}

}
