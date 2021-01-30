package msjo.jotion.zzodeng.Controller;

import java.util.*;
import msjo.jotion.zzodeng.Repository.UserRepository;
import msjo.jotion.zzodeng.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(value = SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void test() {

        List<User> users = (List<User>) userRepository.findAll();

        for(User user : users)
            System.out.println(user);

    }
}