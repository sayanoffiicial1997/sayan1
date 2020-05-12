package com.mindtree.tododiscussionapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.tododiscussionapp.dto.TodoDto;
import com.mindtree.tododiscussionapp.entitty.Todo;
import com.mindtree.tododiscussionapp.exception.TodoException;
import com.mindtree.tododiscussionapp.repository.TodoRepository;
import com.mindtree.tododiscussionapp.service.TodoService;
@Service
public class TodoServiceimpl implements TodoService{
	
	@Autowired
	private TodoRepository repo;

	@Override
	public Todo addTodo(Todo todo) throws TodoException {
		Todo obj= repo.findById(todo.getId()).orElse(null);
		if(obj!=null) {
			throw new TodoException("Its Already present");
		}
		repo.save(todo);
		return todo;
	}

	@Override
	public List<Todo> getAllTodo() {
		
		return repo.findAll();
	}

	@Override
	public Todo getTodoSingle(long id) {
		Todo todo=repo.findById(id).orElse(null);
		return todo;
	}

	@Override
	public Todo updateTodo(Todo todo) throws TodoException {
		Todo obj=repo.findById(todo.getId()).orElse(null);
		if(obj==null) {
			throw new TodoException("Todo Not Present!!");
		}
		obj.setTitle(todo.getTitle());
		obj.setDescription(todo.getDescription());
		obj.setCreatedDate(todo.getCreatedDate());
		obj.setDueDate(todo.getDueDate());
		repo.save(obj);
		return obj;
	}

	@Override
	public TodoDto deletepatient(long id) throws TodoException {
		Todo obj=repo.findById(id).orElse(null);
		if(obj==null) {
			throw new TodoException("Todo Not Present!!");
		}
		repo.deleteById(id);
		TodoDto dto=new TodoDto("Deleted");
		return dto;
	}

}
