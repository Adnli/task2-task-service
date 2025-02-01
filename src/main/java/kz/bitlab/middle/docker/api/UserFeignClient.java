package kz.bitlab.middle.docker.api;

import kz.bitlab.middle.docker.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-feign-client", url = "${feign.user.url}")
public interface UserFeignClient {

    String USER_SERVICE = "/api/user";

    @GetMapping(value = USER_SERVICE + "/getUsers")
    List<UserDTO> getUsersDto();

    @GetMapping(value = USER_SERVICE + "/{id}")
    UserDTO getUserDto(@PathVariable(name = "id") Long id);

    @PostMapping(USER_SERVICE + "/updateUser")
    UserDTO updateUser(UserDTO userDTO);

    @PostMapping(USER_SERVICE + "/addUser")
    UserDTO addUser(UserDTO userDTO);

    @PostMapping(USER_SERVICE + "/deleteUser")
    void deleteUser(UserDTO userDTO);
}
