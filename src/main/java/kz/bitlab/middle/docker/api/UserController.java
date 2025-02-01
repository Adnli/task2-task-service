package kz.bitlab.middle.docker.api;

import kz.bitlab.middle.docker.dto.UserDTO;
import kz.bitlab.middle.docker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/getUsers")
    public List<UserDTO> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/getUser/{id}")
    public UserDTO getUser(@PathVariable(name = "id") Long id){
        return userService.getUser(id);
    }

    @PostMapping("/updateUser")
    public UserDTO getUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @PostMapping("/addUser")
    public UserDTO addUser(@RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }

    @PostMapping("/deleteUser")
    public void deleteUser(@RequestBody UserDTO userDTO){
        userService.deleteUser(userDTO);
    }
}
