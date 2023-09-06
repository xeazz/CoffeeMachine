package my.example.myapp.exception;

/**
 * Created by Dmitrii Vorobev on 05.09.2023.
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String msg) {
        super(msg);
    }
}
