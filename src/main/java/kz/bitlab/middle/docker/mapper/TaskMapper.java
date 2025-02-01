package kz.bitlab.middle.docker.mapper;

import kz.bitlab.middle.docker.dto.TaskDTO;
import kz.bitlab.middle.docker.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "dueDate", source = "date", dateFormat = "dd.MM.yyyy")
    TaskDTO toDto(Task task);

    @Mapping(target = "date", source = "dueDate", dateFormat = "yyyy-MM-dd")
    Task toEntity(TaskDTO taskDto);
}
