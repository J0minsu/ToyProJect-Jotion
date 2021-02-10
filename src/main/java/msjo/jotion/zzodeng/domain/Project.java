package msjo.jotion.zzodeng.domain;

import java.util.*;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.Page;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@ToString
@SuperBuilder
public class Project extends File{

    private List<File> files;

    public String addFile(File file) {

        if(files == null)
            files = new ArrayList<>();

        if (file.getClass() == Project.class)
            return "FAIL_IMPOSSIBLE_PROJECT_IN_PROJECT";

        else {
            files.add(file);
            return "SUCCESS";
        }
    }


}
