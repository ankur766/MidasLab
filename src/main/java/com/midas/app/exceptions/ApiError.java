package com.midas.app.exceptions;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class ApiError {
  private HttpStatus code;
  private String message;
  private String title;
  private String type;
  private List<String> errors;

  public ApiError(HttpStatus status, String title) {
    super();
    this.code = status;
    this.title = title;
  }

  public ApiError(
      HttpStatus status, String title, String type, String message, List<String> errors) {
    super();
    this.code = status;
    this.title = title;
    this.type = type;
    this.message = message;
    this.errors = errors;
  }

  public ApiError(HttpStatus status, String title, String type, String message, String error) {
    super();
    this.code = status;
    this.title = title;
    this.type = type;
    this.message = message;
    this.errors = Arrays.asList(error);
  }

  public ApiError(ApiError apiError) {
    this.code = apiError.getCode();
    this.title = apiError.getTitle();
    this.type = apiError.getType();
    this.message = apiError.getMessage();
    this.errors = apiError.getErrors();
  }

public HttpStatus getCode() {
	return code;
}

public void setCode(HttpStatus code) {
	this.code = code;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public List<String> getErrors() {
	return errors;
}

public void setErrors(List<String> errors) {
	this.errors = errors;
}


}
