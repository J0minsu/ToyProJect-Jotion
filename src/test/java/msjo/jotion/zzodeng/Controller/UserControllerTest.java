package msjo.jotion.zzodeng.Controller;

import java.util.*;

import msjo.jotion.zzodeng.Repository.UserRepository;
import msjo.jotion.zzodeng.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;


@ExtendWith(value = SpringExtension.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void getAllUsersTest() throws Exception{

        List<User> users = userRepository.findAll();


//
//        for(User user : users)
//            userRepository.delete(user);
//
//        List<User> afterUsers = (List<User>) userRepository.findAll();

        for(User user : users)
            System.out.println(user);

    }

    @Test
    public void getOneUserTest() throws Exception {
        Optional<User> user = userRepository.findById("tok0419");

        System.out.println(user);
    }

    @Test
    public void getTest() throws Exception {

        Optional<User> user = userRepository.findById("nhchoi");

        User user1 = user.orElse(null);

        System.out.println(user1);
    }
}