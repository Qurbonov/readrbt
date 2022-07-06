package uz.atm.exceptions;

public class AppBadRequestException extends Throwable {
    private String message;

    public AppBadRequestException(String message) {
        this.message = message;
    }
}
