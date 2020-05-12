package com.mindtree.tododiscussionapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.tododiscussionapp.dto.TodoDto;
import com.mindtree.tododiscussionapp.entitty.Todo;
import com.mindtree.tododiscussionapp.exception.TodoException;

@Service
public interface TodoService {

	Todo addTodo(Todo todo) throws TodoException;

	List<Todo> getAllTodo();

	Todo getTodoSingle(long id);

	Todo updateTodo(Todo todo) throws TodoException;

	TodoDto deletepatient(long id) throws TodoException;

}
