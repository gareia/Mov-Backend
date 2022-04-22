package com.acme.erentcar.service;

import com.acme.erentcar.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface RoleService {
    Role createRole(Role role);
    Role getRolesById(Long roleId);
    Page<Role> getAllRoles(Pageable pageable);
    Role updateRole(Long roleId, Role roleRequest);
    ResponseEntity<?> deleteRole(Long roleId);
}
