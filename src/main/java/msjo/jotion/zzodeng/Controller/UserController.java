package msjo.jotion.zzodeng.Controller;

import java.util.*;

import msjo.jotion.zzodeng.Repository.UserRepository;
import msjo.jotion.zzodeng.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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

    @GetMapping("/api/users/{userId}")
    Optional<User> findUser(@PathVariable String userId) {

        Optional<User> user = userRepository.findById(userId);

        //null 일 때 처리 필요

        return user;
    }

    @PostMapping(path = "/api/users")
    String register(@RequestBody @Valid User user, Errors errors) {


        //validation Error 처리
        if(errors.hasErrors()) {
            StringBuffer buffer = new StringBuffer();
            buffer.append("ERROR_MESSAGE = ");
            for(FieldError error : errors.getFieldErrors()) {
                buffer.append(error.getDefaultMessage() + "\n");
            }

            return buffer.toString();
        }
        else if(userRepository.findById(user.get_id()).isPresent())
            return "Id already exist!";
        else {
            userRepository.save(user);
            return "register is success!";
        }

    }

    @PutMapping(path = "/api/users/{userId}")
    String editUserInfo(@PathVariable String userId, @RequestBody @Valid User user, Errors errors) {

        //validation Error 처리
        if(errors.hasErrors()) {
            StringBuffer buffer = new StringBuffer();
            buffer.append("ERROR_MESSAGE = ");
            for(FieldError error : errors.getFieldErrors()) {
                buffer.append(error.getDefaultMessage() + "\n");
            }

            return buffer.toString();
        }
        else if(!userRepository.findById(user.get_id()).orElse(new User()).equals(userId))
            return "you cannot change ID!";
        else {
            userRepository.save(user);
            return "your information editing is success!";
        }
    }


}
