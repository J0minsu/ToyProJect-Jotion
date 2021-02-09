package msjo.jotion.zzodeng.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class DirectoryTest {


    @Test
    public void test() {

        Directory directory = new Directory("a", "b");
        System.out.println(directory);
    }
}