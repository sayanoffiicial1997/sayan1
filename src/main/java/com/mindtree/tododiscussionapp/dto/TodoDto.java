package com.mindtree.tododiscussionapp.dto;

public class TodoDto {
	
	private String message;
	
	
	@Override
	public String toString() {
		return "TodoDto [message=" + message + "]";
	}


	public TodoDto(String message) {
		super();
		this.message = message;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public TodoDto() {
		// TODO Auto-generated constructor stub
	}

}
