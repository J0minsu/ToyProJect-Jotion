package msjo.jotion.zzodeng.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class DirectoryTest {


    @Test
    public void testInit() {

        Directory directory = Directory.builder()
        .name("first")
        .build();

        System.out.println(directory.getName());
        System.out.println(directory.getDescription());
        System.out.println(directory.getAuthority());
    }

    @Test
    public void testFileHandling() {

        Directory directory = Directory.builder()
        .name("test")
        .build();

        Directory directory1 = Directory.builder()
        .name("test")
        .build();

        Page page = Page.builder()
        .name("testPage")
        .build();

        System.out.println(directory.addFile(page));
        System.out.println(directory.addFile(directory1));

        List<File> files = directory.getFiles();

        while(!files.isEmpty()) {
            System.out.println("enter into the loof");
            File file = files.get(0);
            files.remove(file);
            System.out.println(file);
        }

        Project project = Project.builder()
        .name("testProject")
        .build();

        System.out.println(directory.addFile(project));


    }
}