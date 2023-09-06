package my.example.myapp.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.example.myapp.Repository.AppRepository;
import my.example.myapp.Repository.DrinkRepository;
import my.example.myapp.entity.Drink;
import my.example.myapp.entity.Operation;
import my.example.myapp.exception.BadRequestException;
import my.example.myapp.exception.InternalServerErrorException;
import my.example.myapp.exception.NotFoundException;
import my.example.myapp.mapper.DrinkMapper;
import my.example.myapp.mapper.OperationMapper;
import my.example.myapp.model.DrinkDto;
import my.example.myapp.model.OperationDto;
import my.example.myapp.util.Status;
import my.example.myapp.util.SuccessResponse;
import my.example.myapp.service.AppService;
import my.example.myapp.validation.Validation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Dmitrii Vorobev on 05.09.2023.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AppServiceImpl implements AppService {
    private final AppRepository appRepository;
    private final DrinkRepository drinkRepository;
    private final Validation validation;
    private final DrinkMapper drinkMapper;
    private final OperationMapper operationMapper;


    @Override
    public SuccessResponse start(Status status) {
        checkErrors(status);
        addOperations(status);
        log.info("Success start coffee machine");
        return SuccessResponse.builder()
                .message("Coffee Machine is ON!")
                .build();
    }

    @Override
    public SuccessResponse stop(Status status) {
        checkErrors(status);
        addOperations(status);
        log.info("Success stop coffee machine");
        return SuccessResponse.builder()
                .message("Coffee Machine is OFF!")
                .build();
    }

    @Override
    public List<OperationDto> getAllOperations(Status status) {
        checkErrors(status);
        if (appRepository.count() == 0) {
            log.error("Error getting history coffee machine!");
            throw new NotFoundException("Command history is empty!");
        }
        log.info("Successfully getting history coffee machine!");
        return appRepository.findAll().stream()
                .map(operationMapper::toOperationDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<DrinkDto> menu(Status status) {
        checkErrors(status);
        addOperations(status);
        log.info("Successfully getting menu coffee machine!");
        return drinkRepository.findAll().stream()
                .map(drinkMapper::toDrinkDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public SuccessResponse deletePosition(Long id, Status status) {
        checkErrors(status);
        if (drinkRepository.findById(id).isEmpty()) {
            log.error("Wrong item number entered!");
            throw new NotFoundException("Wrong item number entered!");
        }
        log.info("Successfully deleted menu position coffee machine!");
        drinkRepository.deleteById(id);
        addOperations(status);
        return SuccessResponse.builder()
                .message("Position cleared successfully")
                .build();
    }

    @Override
    @Transactional
    public SuccessResponse makeCoffee(Long id, Status status) {
        checkErrors(status);
        Optional<Drink> drink = drinkRepository.findById(id);
        if (drink.isEmpty()) {
            log.error("Wrong item number entered!");
            throw new NotFoundException("Wrong item number entered!");
        }
        addOperations(status);
        log.info("Coffee command completed!");
        return SuccessResponse.builder()
                .message(String.format("\"%s\" is ready",
                        drink.map(drinkMapper::toDrinkDto)
                                .get()
                                .getName()))
                .build();
    }

    @Override
    @Transactional
    public SuccessResponse addPosition(DrinkDto drinkDto, Status status) {
        checkErrors(status);
        Drink drink = drinkMapper.toDrink(drinkDto);
        if (drinkRepository.findByName(drink.getName()).isPresent()) {
            log.error("A product with the same name already exists");
            throw new BadRequestException("A product with the same name already exists");
        }
        drinkRepository.save(drink);
        addOperations(status);
        log.info("New position in coffee machine successfully added!");
        return SuccessResponse.builder()
                .message(String.format("\"%s\" successfully added",
                        drinkDto.getName()))
                .build();
    }

    @Override
    @Transactional
    public SuccessResponse updateCost(String name, Long cost, Status status) {
        checkErrors(status);
        if (drinkRepository.findByName(name).isEmpty()) {
            log.error("There is no product with this name");
            throw new NotFoundException("There is no product with this name");
        }
        drinkRepository.updateCostByName(name, cost);
        addOperations(status);
        log.info("Changed price was successfully!");
        return SuccessResponse.builder()
                .message("Price changed successfully")
                .build();
    }

    private void checkErrors(Status status) {
        if (!validation.checkStatus(status)) {
            log.error("Trouble on the SERVER :(");
            throw new InternalServerErrorException("Trouble on the SERVER :(");
        }
        log.info("Validation is successful!");
    }

    private void addOperations(Status status) {
        log.info("Operation status registered!");
        appRepository.save(Operation.builder()
                .localDateTime(LocalDateTime.now())
                .status(status.name())
                .build());
    }
}
