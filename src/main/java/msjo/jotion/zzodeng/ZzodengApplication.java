package msjo.jotion.zzodeng;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class ZzodengApplication {



    @Autowired
    MongoDatabaseFactory mongoDatabaseFactory;

    public static void main(String[] args) {
        SpringApplication.run(ZzodengApplication.class, args);
    }




    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            MongoDatabase mongoDatabase = mongoDatabaseFactory.getMongoDatabase();

            mongoDatabase.getCollection("A.B").insertOne(
                    new Document()
                            .append("id", 3)
                            .append("name", "jslee")
                            .append("city", "Gyeyang")

            );
        };
    }

}
