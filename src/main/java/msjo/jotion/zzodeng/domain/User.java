package msjo.jotion.zzodeng.domain;


import lombok.*;
import java.util.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document("users")
public class User {

    @Id
    @Size(min = 4, max = 16, message = "Id's size is 4 to 16")
    private String _id;

    @Size(min = 4, max = 16, message = "name's size is 4 to 16")
    @NotNull(message = "Write your name!!")
    private String name;
    private String city;

    private List<Project> projects;


}
