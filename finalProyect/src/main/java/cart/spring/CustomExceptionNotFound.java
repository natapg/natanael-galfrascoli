package cart.spring;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomExceptionNotFound extends Exception {

  String message;

  public CustomExceptionNotFound(String message) {
    super(message);
    this.message = message;
  }

}