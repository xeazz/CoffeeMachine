package my.example.myapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

/**
 * Created by Dmitrii Vorobev on 05.09.2023.
 */
@Entity
@Table(schema = "coffee_machine", name = "operations")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "datetime")
    private LocalDateTime localDateTime;
    @Column(name = "status")
    private String status;
}
