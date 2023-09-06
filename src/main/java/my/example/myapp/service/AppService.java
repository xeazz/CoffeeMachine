package my.example.myapp.service;

import my.example.myapp.model.DrinkDto;
import my.example.myapp.model.OperationDto;
import my.example.myapp.util.Status;
import my.example.myapp.util.SuccessResponse;

import java.util.List;

/**
 * Created by Dmitrii Vorobev on 05.09.2023.
 */
public interface AppService {
    SuccessResponse start(Status status);

    SuccessResponse stop(Status status);

    List<OperationDto> getAllOperations(Status status);

    List<DrinkDto> menu(Status status);

    SuccessResponse addPosition(DrinkDto drinkDto, Status status);

    SuccessResponse deletePosition(Long id, Status status);

    SuccessResponse makeCoffee(Long id, Status status);

    SuccessResponse updateCost(String name, Long id, Status status);
}
