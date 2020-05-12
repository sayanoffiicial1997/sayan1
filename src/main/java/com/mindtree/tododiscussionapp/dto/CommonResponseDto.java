package com.mindtree.tododiscussionapp.dto;

import java.util.Date;

public class CommonResponseDto {
	private Date responseDate;
	private Object response;
	private Object error;
	private boolean success;
	
	
	public CommonResponseDto(Date responseDate, Object response, Object error, boolean success) {
		super();
		this.responseDate = responseDate;
		this.response = response;
		this.error = error;
		this.success = success;
	}


	@Override
	public String toString() {
		return "CommonResponseDto [responseDate=" + responseDate + ", response=" + response + ", error=" + error
				+ ", success=" + success + "]";
	}


	public Date getResponseDate() {
		return responseDate;
	}


	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}


	public Object getResponse() {
		return response;
	}


	public void setResponse(Object response) {
		this.response = response;
	}


	public Object getError() {
		return error;
	}


	public void setError(Object error) {
		this.error = error;
	}


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public CommonResponseDto() {
		// TODO Auto-generated constructor stub
	}

}
