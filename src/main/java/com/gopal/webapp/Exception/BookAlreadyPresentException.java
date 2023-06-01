package com.gopal.webapp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT,reason="Book Already Present In Library")
public class BookAlreadyPresentException extends Exception {

}
