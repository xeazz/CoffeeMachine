package my.example.myapp.util;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * Created by Dmitrii Vorobev on 05.09.2023.
 */

@Data
@Builder
@Schema(name="Information", description="Successful response")
public class SuccessResponse {
    private String message;
}
