package kz.bitlab.middle.docker.service;

import kz.bitlab.middle.docker.api.UserFeignClient;
import kz.bitlab.middle.docker.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserFeignClient userFeignClient;

    public List<UserDTO> getUsers(){
        return userFeignClient.getUsersDto();
    }

    public UserDTO getUser(Long id){
        return userFeignClient.getUserDto(id);
    }

    public UserDTO updateUser(UserDTO userDTO){
        return userFeignClient.updateUser(userDTO);
    }

    public UserDTO addUser(UserDTO userDTO){
        return userFeignClient.addUser(userDTO);
    }

    public void deleteUser(UserDTO userDTO){
        userFeignClient.deleteUser(userDTO);
    }
}
