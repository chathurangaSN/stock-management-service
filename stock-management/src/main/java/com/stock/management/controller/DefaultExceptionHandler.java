package com.stock.management.controller;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class DefaultExceptionHandler  extends ResponseEntityExceptionHandler{
	public final String responseFailed = "Failed";
	
	
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorMessage> someError(MethodArgumentNotValidException ex ){
		String message = "";
		System.out.println("asdfghjkfdASDF");
		System.out.println("System.out.println(\"asdfghjkfdASDF\");"+ex.getBindingResult().getAllErrors().size());
		System.out.println("asdfghjkfdASDF");
		for (int i = 0; i < ex.getBindingResult().getAllErrors().size(); i++) {
			message = message + ex.getBindingResult().getAllErrors().get(i).getDefaultMessage() +"\n";
			System.out.println(ex.getBindingResult().getAllErrors().get(i).getDefaultMessage());
		}
		ErrorMessage errorMessage = new ErrorMessage(message, responseFailed);
		
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		 
	}
	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<ErrorMessage> nullError(RuntimeException ex ){
		
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), responseFailed);
		
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		 
	}
//	 @ExceptionHandler(Exception.class)
//	  public final ResponseEntity<Object> handleAllExceptions(MethodArgumentNotValidException ex, WebRequest request) {
//	    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(),
//	        request.getDescription(false));
//	    return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
//	  }
	 
	 @Override
	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {
//	    ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed",
//	    		ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
//	    return new ResponseEntity(errorDetails, HttpStatus.BAD_GATEWAY);
//		 ErrorMessage errorMessage = new ErrorMessage(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(), responseFailed);
		 String message = "Please provide ";
		
			for (int i = 0; i < ex.getBindingResult().getAllErrors().size(); i++) {
				
				if(i == 0) {
					message = message + ex.getBindingResult().getAllErrors().get(i).getDefaultMessage();
				}else {
					message = message +" & " + ex.getBindingResult().getAllErrors().get(i).getDefaultMessage() ;
				}
			}
			ErrorMessage errorMessage = new ErrorMessage(message, responseFailed);
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	  } 
	
	 
	 
//	 @ExceptionHandler(StudentNotFoundException.class)
//	  public final ResponseEntity<ErrorDetails> handleUserNotFoundException(StudentNotFoundException ex, WebRequest request) {
//	    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
//	        request.getDescription(false));
//	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//	  }
	 
	
//	public class StudentNotFoundException extends RuntimeException {
//		
//		
//		public StudentNotFoundException(String exception) {
//			super(exception);
//		}
//	}

	public class ErrorDetails {
		  private Date timestamp;
		  private String message;
		  private String details;
		  public ErrorDetails(Date timestamp, String message, String details) {
		    super();
		    this.timestamp = timestamp;
		    this.message = message;
		    this.details = details;
		  }
		  public Date getTimestamp() {
		    return timestamp;
		  }
		  public String getMessage() {
		    return message;
		  }
		  public String getDetails() {
		    return details;
		  }
		}
	
	public class ErrorMessage {
		
		String response;
    	String message; 
    	
    	public ErrorMessage() {
    		super();
		}
    	public ErrorMessage(String message, String response) {
    		super();
    		this.message = message;
    		this.response = response;
		}

		public String getResponse() {
			return response;
		}

		public void setResponse(String response) {
			this.response = response;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		
	}
}
