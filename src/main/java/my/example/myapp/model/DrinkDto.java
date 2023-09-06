package my.example.myapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmitrii Vorobev on 05.09.2023.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrinkDto {
    private Long id;
    private String name;
    private Double cost;
    private Double volume;
    private String description;
    private Map<String, String> ingredients = new HashMap<>();
}
