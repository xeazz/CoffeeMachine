package my.example.myapp.validation;

import lombok.extern.slf4j.Slf4j;
import my.example.myapp.exception.BadRequestException;
import my.example.myapp.exception.InternalServerErrorException;
import my.example.myapp.util.Status;
import org.springframework.stereotype.Component;

/**
 * Created by Dmitrii Vorobev on 03.09.2023.
 */
@Component
@Slf4j
public class Validation {
    private static boolean IS_ENABLE = false;

    public boolean checkStatus(Status status) {
        switch (status) {
            case ACTIVE -> {
                if (IS_ENABLE) {
                    log.error("ERROR: The Coffee Machine is already ON!");
                    throw new BadRequestException("The Coffee Machine is already ON");
                } else {
                    IS_ENABLE = true;
                    return true;
                }
            }
            case INACTIVE -> {
                if (!IS_ENABLE) {
                    log.error("ERROR: The Coffee Machine is already OFF");
                    throw new InternalServerErrorException("The Coffee Machine is already OFF");
                } else {
                    IS_ENABLE = false;
                    return true;
                }
            }
            case DELETE, MAKING, INFO, ADD, UPDATE -> {
                if (!IS_ENABLE) {
                    log.error("ERROR: The Coffee Machine if OFF");
                    throw new InternalServerErrorException("The Coffee Machine if OFF");
                } else {
                    return true;
                }
            }
            default -> {
                return false;
            }
        }
    }

}

