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
    public void testForConstructor() {



    }

//    @Test
//    public void testForThreeType() {
//
//        List<File> files = new ArrayList<>();
//        files.add(new Project());
//        files.add(new Directory());
//        files.add(new Page());
//
//        for(File f : files)
//            System.out.println(f);
//
//    }
//
//    @Test
//    public void testForChangeOrder() {
//
//        List<File> files = new ArrayList<>();
//        files.add(new Project());
//        files.add(new Directory());
//        files.add(new Page());
//
//
//        System.out.println("1st call");
//
//        for(File f : files)
//            System.out.println(f);
//
//        System.out.println("2nd call");
//
//        for(File f : files)
//            System.out.println(f);
//
//        System.out.println("3rd call");
//
//        for(File f : files)
//            System.out.println(f);
//
//        System.out.println("move first element to last");
//
//        File f1 = files.get(0);
//        files.remove(f1);
//        files.add(f1);
//
//        for(File f : files)
//            System.out.println(f);
//    }

}