package kz.bitlab.middle.docker.service;

import kz.bitlab.middle.docker.dto.TaskDTO;
import kz.bitlab.middle.docker.dto.UserDTO;
import kz.bitlab.middle.docker.mapper.TaskMapper;
import kz.bitlab.middle.docker.model.Task;
import kz.bitlab.middle.docker.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;
    private final TaskMapper taskMapper;

    public List<TaskDTO> getTasks(Long authorId){
        UserDTO user = userService.getUser(authorId);
        List<Task> tasks = taskRepository.findAllByAuthorId(authorId);
        List<TaskDTO> tasksDto = new ArrayList<>();
        for (Task t: tasks){
            TaskDTO taskDTO = taskMapper.toDto(t);
            taskDTO.setAuthor(user);
            tasksDto.add(taskDTO);
        }
        return tasksDto;
    }

    public TaskDTO getTask(Long taskId, Long userId){
        TaskDTO taskDTO = taskMapper.toDto(taskRepository.findTaskById(taskId));
        if(taskDTO.getAuthor().getId().equals(userId)){
            return taskDTO;
        } else {
            return null;
        }
    }

    public Task addTask(TaskDTO taskDto){
        Task task = taskMapper.toEntity(taskDto);
        return taskRepository.save(task);
    }

    public Task updateTask(TaskDTO taskDTO){
        Task task = new Task();
        if(taskRepository.findById(taskDTO.getId()).isPresent()){
            task = taskMapper.toEntity(taskDTO);
            return taskRepository.save(task);
        }
        return task;
    }

    public void deleteTask(Long id) {
        taskRepository.findById(id).ifPresent(taskRepository::delete);
    }
}