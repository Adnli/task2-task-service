package kz.bitlab.middle.docker.mapper;

import kz.bitlab.middle.docker.dto.TaskDTO;
import kz.bitlab.middle.docker.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "date", source = "dueDate")
    TaskDTO toDto(Task task);

    @Mapping(target = "dueDate", source = "date")
    Task toEntity(TaskDTO taskDto);
}
