package com.test.ContactBook.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
public class ContactDTO {
    public interface New{

    }

    public interface Update{

    }

    @Null(groups = {New.class})
    @NotNull(groups = {Update.class})
    private Long id;
    @NotNull(groups = {New.class, Update.class})
    private String firstName;
    @NotNull(groups = {New.class, Update.class})
    private String lastName;
    @NotNull(groups = {New.class, Update.class})
    private String email;

}
