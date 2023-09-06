package my.example.myapp.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmitrii Vorobev on 05.09.2023.
 */
@Entity
@Table(schema = "coffee_machine", name = "drink")
@Data
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "cost")
    private Double cost;
    @Column(name = "volume")
    private Double volume;
    @Column(name = "description")
    private String description;

    @ElementCollection
    @CollectionTable(schema = "coffee_machine",
            name = "ingredients",
            joinColumns = @JoinColumn(name = "drink_id"))
    @MapKeyColumn(name = "key")
    @Column(name = "value")
    private Map<String, String> ingredients = new HashMap<>();
}
