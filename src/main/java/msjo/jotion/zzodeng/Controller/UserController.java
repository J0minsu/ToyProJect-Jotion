package msjo.jotion.zzodeng.Controller;

import java.util.*;

import msjo.jotion.zzodeng.Repository.UserRepository;
import msjo.jotion.zzodeng.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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

    @PostMapping(path = "api/user")
    String register(@RequestBody @Valid User user, Errors errors) {

        String errorMessage = "";
        if(errors.hasErrors()) {

            for(FieldError error : errors.getFieldErrors())
                errorMessage += error.getDefaultMessage();

            return "{\"message\" : \"" + errorMessage + "\"}";
        }

        else if(userRepository.findById(user.get_id()) != null)
            return "Id is already exist!!!!";

        userRepository.save(user);

        return "register is success!";
    }


}
