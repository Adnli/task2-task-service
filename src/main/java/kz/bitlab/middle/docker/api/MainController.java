package kz.bitlab.middle.docker.api;

import kz.bitlab.middle.docker.dto.TaskDTO;
import kz.bitlab.middle.docker.model.Task;
import kz.bitlab.middle.docker.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v2")
@RequiredArgsConstructor
public class MainController {

    private final TaskService taskService;

    @GetMapping(value = "/getTasks")
    public ResponseEntity<List<TaskDTO>> getTasks(@RequestParam(name = "id") Long authorId){
        return new ResponseEntity<>(taskService.getTasks(authorId), HttpStatus.OK);
    }

    @GetMapping(value = "/getTask")
    public ResponseEntity<TaskDTO> getTask(@RequestParam (name = "taskId") Long taskId,
                                           @RequestParam (name = "userId") Long authorId){
        return new ResponseEntity<>(taskService.getTask(taskId, authorId), HttpStatus.OK);
    }

    @PostMapping(value = "/addTask")
    public ResponseEntity<Task> addTask(@RequestBody TaskDTO taskDto){
        return new ResponseEntity<>(taskService.addTask(taskDto), HttpStatus.OK);
    }

    @PostMapping(value = "/updateTask")
    public ResponseEntity<Task> updateTask(@RequestBody TaskDTO taskDto){
        return new ResponseEntity<>(taskService.updateTask(taskDto), HttpStatus.OK);
    }

    @PostMapping(value = "/deleteTask/{id}")
    public void deleteTask(@RequestParam(name = "id") Long id){
        taskService.deleteTask(id);
    }
}
