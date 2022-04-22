package com.acme.erentcar.service;

import com.acme.erentcar.exception.ResourceNotFoundException;
import com.acme.erentcar.model.Role;
import com.acme.erentcar.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getRolesById(Long roleId) {
        return roleRepository.findById(roleId)
                .orElseThrow(()->new ResourceNotFoundException("Role", "Id", roleId));
    }

    @Override
    public Page<Role> getAllRoles(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    @Override
    public Role updateRole(Long roleId, Role roleRequest) {
        Role role = getRolesById(roleId);
        role.setName(roleRequest.getName());
        return roleRepository.save(role);
    }

    @Override
    public ResponseEntity<?> deleteRole(Long roleId) {
        Role role = getRolesById(roleId);
        roleRepository.delete(role);
        return ResponseEntity.ok().build();
    }
}
