package com.acme.erentcar.resource;

import com.acme.erentcar.model.Audit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleResource extends Audit {
    private Long id;
    private String name;
}
