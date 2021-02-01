package msjo.jotion.zzodeng.Controller;

import java.util.*;
import msjo.jotion.zzodeng.Repository.UserRepository;
import msjo.jotion.zzodeng.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping("api/user")
    String register(@RequestBody User user) {

        return "hello";
    }


}
