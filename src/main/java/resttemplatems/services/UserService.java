package resttemplatems.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import resttemplatems.dto.UserDTO;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Value("${spring.external.service.base-url}")
    private String basePath;

    @Autowired
    private RestTemplate restTemplate;

    public List<UserDTO> getAllUsers(){
        UserDTO[] response = restTemplate.getForObject(basePath + "/users", UserDTO[].class);//consulta directa
        return Arrays.asList(response);
    }

    public void saveUser(UserDTO user){
        restTemplate.postForObject(basePath+"/users", user, UserDTO.class);
    }

    public void updateUser(Integer id, UserDTO user) {
        restTemplate.put(basePath+"/users/"+id,user);
    }

    public void deleteUser(Integer id){
        restTemplate.delete(basePath+"/users/"+id);
    }

}
