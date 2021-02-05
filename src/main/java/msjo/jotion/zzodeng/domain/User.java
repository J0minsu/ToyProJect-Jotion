package msjo.jotion.zzodeng.domain;


import lombok.*;
import java.util.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document("users")

public class User {

    @Id
    private String _id;
    private String name;
    private String city;

    private List<Project> projects;


}
