package com.test.ContactBook.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
public class PhoneNumberDTO {
    public interface New{

    }

    public interface Update{

    }

    @Null(groups = {New.class})
    @NotNull(groups = {Update.class})
    private Long id;
    @NotNull(groups = {New.class, Update.class})
    private String operatorName;
    @NotNull(groups = {New.class, Update.class})
    private String number;
    @NotNull(groups = {New.class, Update.class})
    private Long contactID;
}
