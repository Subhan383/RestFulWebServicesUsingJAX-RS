package org.restapp.showrrom.model;

public class ErrorPayLoad {

	private int statusCode;
	private String errorMessage;

	public ErrorPayLoad() {

	}

	public ErrorPayLoad(int statusCode, String errorMessage) {

		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
