package msjo.jotion.zzodeng.Controller;

import java.util.*;
import msjo.jotion.zzodeng.Repository.UserRepository;
import msjo.jotion.zzodeng.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableAutoConfiguration
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }


    @GetMapping("/api/users")
    List<User> findAllUser() {

        return (List<User>) userRepository.findAll();
    }
}
