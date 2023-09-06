package my.example.myapp.mapper;

import my.example.myapp.entity.Operation;
import my.example.myapp.model.OperationDto;
import org.mapstruct.Mapper;

/**
 * Created by Dmitrii Vorobev on 06.09.2023.
 */
@Mapper(componentModel = "spring")
public interface OperationMapper {
    OperationDto toOperationDto(Operation operation);
}
