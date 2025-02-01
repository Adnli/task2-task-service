package kz.bitlab.middle.docker.api;

import kz.bitlab.middle.docker.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-feign-client", url = "${feign.user.url}")
public interface UserFeignClient {

    @GetMapping(value = "/getUsers")
    List<UserDTO> getUsersDto();

    @GetMapping(value = "/{id}")
    UserDTO getUserDto(@PathVariable(name = "id") Long id);

    @PostMapping("/updateUser")
    UserDTO updateUser(UserDTO userDTO);

    @PostMapping("/addUser")
    UserDTO addUser(UserDTO userDTO);

    @PostMapping("/deleteUser")
    void deleteUser(UserDTO userDTO);
}
