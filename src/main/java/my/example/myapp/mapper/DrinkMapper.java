package my.example.myapp.mapper;
import my.example.myapp.entity.Drink;
import my.example.myapp.model.DrinkDto;
import org.mapstruct.Mapper;

/**
 * Created by Dmitrii Vorobev on 05.09.2023.
 */


@Mapper(componentModel = "spring")
public interface DrinkMapper {
    Drink toDrink(DrinkDto drinkDto);
    DrinkDto toDrinkDto(Drink drink);


}
