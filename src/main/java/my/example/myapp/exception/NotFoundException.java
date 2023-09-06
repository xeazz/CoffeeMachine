package my.example.myapp.exception;

/**
 * Created by Dmitrii Vorobev on 05.09.2023.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String msg) {
        super(msg);
    }
}