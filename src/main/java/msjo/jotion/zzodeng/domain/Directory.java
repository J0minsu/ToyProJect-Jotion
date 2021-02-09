package msjo.jotion.zzodeng.domain;

import java.util.*;

import lombok.*;
import org.springframework.data.domain.Page;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@ToString
public class Directory extends File{

    @Builder
    public Directory(@NotNull(message = "Please write this file's name!") @Max(value = 96, message = "Name of file max length is 96!") String name, String description) {
        super(name, description);
    }
}
