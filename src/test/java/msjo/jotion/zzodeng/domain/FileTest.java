package msjo.jotion.zzodeng.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(value = SpringExtension.class)
@SpringBootTest
class FileTest {


    @Test
    public void testForThreeType() {

        List<File> files = new ArrayList<>();
        files.add(new Project());
        files.add(new Directory());
        files.add(new Page());

        for(File f : files)
            System.out.println(f);


    }

}