package msjo.jotion.zzodeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class ZzodengApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZzodengApplication.class, args);
    }


}
