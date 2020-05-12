package com.mindtree.tododiscussionapp.controller;

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

import com.mindtree.tododiscussionapp.dto.TodoDto;
import com.mindtree.tododiscussionapp.entitty.Todo;
import com.mindtree.tododiscussionapp.exception.ServiceException;
import com.mindtree.tododiscussionapp.exception.TodoException;
import com.mindtree.tododiscussionapp.service.TodoService;
@CrossOrigin
@RequestMapping("/todo")
@RestController
public class TodoController {

	@Autowired
	private TodoService service;
	
	@PostMapping("/addtodo")
	public ResponseEntity<?> addTodo(@RequestBody Todo todo) throws ServiceException{
		try {
			System.out.println("add rcchd");
			return new ResponseEntity<Todo>(service.addTodo(todo), HttpStatus.ACCEPTED);
		} catch (TodoException e) {
			throw new ServiceException(e.getMessage());
		} 
	}
	
	@GetMapping("/display")
	public ResponseEntity<?> displayAll(){
		System.out.println("Display rchd");
		return new ResponseEntity<List<Todo>>(service.getAllTodo(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/displaysingletodo/{id}")
	public ResponseEntity<?> displaySingleTodo(@PathVariable long id){
		System.out.println("sayan");
		System.out.println(id);
		return new ResponseEntity<Todo>(service.getTodoSingle(id),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updatetodo")
	public ResponseEntity<?> updateTodo(@RequestBody Todo todo) throws ServiceException {
			System.out.println("update");
			System.out.println(todo);
			System.out.println("Update CoNTROLLER REACHED");
			try {
				return new ResponseEntity<Todo>(service.updateTodo(todo), HttpStatus.ACCEPTED);
			} catch (TodoException e) {
				throw new ServiceException(e.getMessage());
			}
		
	}
	@DeleteMapping("/deletetodo/{id}")
	public ResponseEntity<?> deleteTodo(@PathVariable long id) throws ServiceException{
		try {
			return new ResponseEntity<TodoDto>(service.deletepatient(id), HttpStatus.ACCEPTED);
		} catch (TodoException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	

}
