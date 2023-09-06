package my.example.myapp.mapper;

import javax.annotation.processing.Generated;
import my.example.myapp.entity.Operation;
import my.example.myapp.model.OperationDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-06T14:29:39+0300",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230721-1147, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class OperationMapperImpl implements OperationMapper {

    @Override
    public OperationDto toOperationDto(Operation operation) {
        if ( operation == null ) {
            return null;
        }

        OperationDto operationDto = new OperationDto();

        operationDto.setId( operation.getId() );
        operationDto.setLocalDateTime( operation.getLocalDateTime() );
        operationDto.setStatus( operation.getStatus() );

        return operationDto;
    }
}
