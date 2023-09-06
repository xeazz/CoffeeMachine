package my.example.myapp.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by Dmitrii Vorobev on 06.09.2023.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationDto {
    private Long id;
    private LocalDateTime localDateTime;
    private String status;
}
