package my.example.myapp.exception;

/**
 * Created by Dmitrii Vorobev on 05.09.2023.
 */
public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String msg) {
        super(msg);
    }
}
