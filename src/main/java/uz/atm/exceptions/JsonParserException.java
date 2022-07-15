package uz.atm.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonParserException extends RuntimeException {
    public JsonParserException(String message) {
        super(message);
    }

}
