package msjo.jotion.zzodeng.domain;


import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class File {

    @NotNull(message = "Please write this file's name!")
    @Max(value = 96, message = "Name of file max length is 96!")
    private String name;
    private String description;

    private Authority authority;

}
