package msjo.jotion.zzodeng.Controller;

import java.util.*;

import msjo.jotion.zzodeng.Repository.UserRepository;
import msjo.jotion.zzodeng.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
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
    ResponseEntity<List<User>> findAllUser() {

        List<User> users = new ArrayList<User>();
        Iterable<User> userIterable = userRepository.findAll();

        userIterable.forEach(users::add);

        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping("/api/users/{userId}")
    ResponseEntity<User> findUser(@PathVariable String userId) {

        User user = userRepository.findById(userId).orElse(new User());

        //조회결과가 없을 때
        if(user.get_id() == null)
            return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<User>(user, HttpStatus.OK);

    }

    @PostMapping(path = "/api/users")
    ResponseEntity<String> register(@RequestBody @Valid User user, Errors errors) {


        //validation Error 처리
        if(errors.hasErrors()) {
            StringBuffer buffer = new StringBuffer();
            buffer.append("ERROR_MESSAGE = ");
            for(FieldError error : errors.getFieldErrors()) {
                buffer.append(error.getDefaultMessage() + "\n");
            }

            return new ResponseEntity<String>(buffer.toString(), HttpStatus.BAD_REQUEST);
        }
        else if(userRepository.findById(user.get_id()).isPresent())
            return new ResponseEntity<String>("Id already exist!", HttpStatus.FOUND);
        else {
            userRepository.save(user);
            return new ResponseEntity<String>("register is success!\nThanks " + user.getName(), HttpStatus.CREATED);
        }

    }

    @PutMapping(path = "/api/users/{userId}")
    ResponseEntity<String> editUserInfo(@PathVariable String userId, @RequestBody @Valid User user, Errors errors) {

        //validation Error 처리
        if(errors.hasErrors()) {
            StringBuffer buffer = new StringBuffer();
            buffer.append("ERROR_MESSAGE = ");
            for(FieldError error : errors.getFieldErrors()) {
                buffer.append(error.getDefaultMessage() + "\n");
            }

            return new ResponseEntity<String>(buffer.toString(), HttpStatus.BAD_REQUEST);
        }
        else if(!userRepository.findById(user.get_id()).orElse(new User())
                                                       .get_id().equals(userId))
            return new ResponseEntity<String>("you cannot change ID! + ", HttpStatus.BAD_REQUEST);
        else {
            userRepository.save(user);
            return new ResponseEntity<String>("your information editing is success!", HttpStatus.OK);
        }
    }

    @DeleteMapping(path = "/api/users/{userId}")
    ResponseEntity<String> withdrawal(@PathVariable String userId) {

        userRepository.deleteById(userId);

        return new ResponseEntity<>("Thanks for using our sevice!", HttpStatus.NO_CONTENT);
    }


}
