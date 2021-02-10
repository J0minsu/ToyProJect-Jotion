package msjo.jotion.zzodeng.domain;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@SuperBuilder
public class File {

    @NotNull(message = "Please write this file's name!")
    @Max(value = 48, message = "Name of file max length is 96!")
    private String name;

    @NotNull(message =  "Please describe about this file!")
    @Builder.Default
    private String description = "";

    @Builder.Default
    private Authority authority = Authority.CREW;



}
