package com.teamproject1.scuoledevelhope.classes.role.controller;

import com.bananapilot.samplespringauthenticationframework.filtes.annotations.FloorLevelAuthorization;
import com.bananapilot.samplespringauthenticationframework.filtes.annotations.NoAuthorization;
import com.teamproject1.scuoledevelhope.classes.role.dto.RoleUsername;
import com.teamproject1.scuoledevelhope.classes.role.dto.RolesUser;
import com.teamproject1.scuoledevelhope.classes.role.service.RoleService;
import com.teamproject1.scuoledevelhope.types.dtos.BaseResponseElement;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @PutMapping("/add")
    public BaseResponseElement<RolesUser> addRoleToUser(@Valid @RequestBody RoleUsername roleUsername) {
        return roleService.addRole(roleUsername);
    }

    @FloorLevelAuthorization(floorRole = "ADMIN")
    @PutMapping("/remove")
    public BaseResponseElement<RolesUser> removeRoleFromUser(@Valid @RequestBody RoleUsername roleUsername) {
        return roleService.deleteRole(roleUsername);
    }
}
