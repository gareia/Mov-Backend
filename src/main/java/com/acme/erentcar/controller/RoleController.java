package com.acme.erentcar.controller;

import com.acme.erentcar.model.Role;
import com.acme.erentcar.resource.RoleResource;
import com.acme.erentcar.resource.SaveRoleResource;
import com.acme.erentcar.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private RoleService roleService;

    private Role convertToEntity(SaveRoleResource resource){
        return mapper.map(resource, Role.class);
    }
    private RoleResource convertToResource(Role entity){
        return mapper.map(entity, RoleResource.class);
    }

    @GetMapping("/roles")
    public Page<RoleResource> getAllRoles(Pageable pageable){
        Page<Role> roles = roleService.getAllRoles(pageable);
        List<RoleResource> resources = roles.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

}
