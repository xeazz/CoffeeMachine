package my.example.myapp.mapper;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import my.example.myapp.entity.Drink;
import my.example.myapp.model.DrinkDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-06T14:29:39+0300",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230721-1147, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class DrinkMapperImpl implements DrinkMapper {

    @Override
    public Drink toDrink(DrinkDto drinkDto) {
        if ( drinkDto == null ) {
            return null;
        }

        Drink drink = new Drink();

        drink.setCost( drinkDto.getCost() );
        drink.setDescription( drinkDto.getDescription() );
        drink.setId( drinkDto.getId() );
        Map<String, String> map = drinkDto.getIngredients();
        if ( map != null ) {
            drink.setIngredients( new LinkedHashMap<String, String>( map ) );
        }
        drink.setName( drinkDto.getName() );
        drink.setVolume( drinkDto.getVolume() );

        return drink;
    }

    @Override
    public DrinkDto toDrinkDto(Drink drink) {
        if ( drink == null ) {
            return null;
        }

        DrinkDto drinkDto = new DrinkDto();

        drinkDto.setCost( drink.getCost() );
        drinkDto.setDescription( drink.getDescription() );
        drinkDto.setId( drink.getId() );
        Map<String, String> map = drink.getIngredients();
        if ( map != null ) {
            drinkDto.setIngredients( new LinkedHashMap<String, String>( map ) );
        }
        drinkDto.setName( drink.getName() );
        drinkDto.setVolume( drink.getVolume() );

        return drinkDto;
    }
}
