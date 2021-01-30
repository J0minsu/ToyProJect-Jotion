package msjo.jotion.zzodeng.Repository;

import msjo.jotion.zzodeng.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(value = SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {


    @Autowired
    private UserRepository userRepository;

    @Test
    public void name() throws Exception {

        assertEquals("hello","hello");
    }

    @Test
    public void save() throws Exception {

        User user = new User(1,"msjo","Incheon");

        userRepository.delete(user);
        assertEquals(0, userRepository.count());

        userRepository.save(user);
        assertEquals(1, userRepository.count());

        Optional<User> findUser = userRepository.findById(user.getId());

        assertEquals("msjo", findUser.get().getName());


    }



}