package cart.spring;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomExceptionBadRequest extends Exception {

  String message;

  public CustomExceptionBadRequest(String message) {
    super(message);
    this.message = message;
  }

}