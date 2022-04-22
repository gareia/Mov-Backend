package com.acme.erentcar.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SaveRoleResource {

    @NotNull
    @NotBlank
    @Size(max=100)
    private String name;
}
