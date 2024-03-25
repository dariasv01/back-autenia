package com.api.crud.infrastructure.controllers;

import com.api.crud.application.services.UserGroupServices;
import com.api.crud.domain.models.Group;
import com.api.crud.domain.models.UserGroup;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usersGroup")
public class UserGroupController {
    private UserGroupServices userGroupServices;

    public UserGroupController(UserGroupServices userGroupServices) {
        this.userGroupServices = userGroupServices;
    }

    @PostMapping
    public ResponseEntity<UserGroup> createUserGroup(@RequestBody UserGroup userGroup){
        UserGroup createdUser = userGroupServices.createUserGroup(userGroup);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<UserGroup> getGroupById(@PathVariable Long groupId){
        return userGroupServices.getUserGroup(groupId).map(group -> new ResponseEntity<>(group,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/byIdUser/{userId}")
    public ResponseEntity<List<UserGroup>> getGroupByUser(@PathVariable Long userId){
        List<UserGroup> groups = userGroupServices.getAllGroup(userId);
        return new ResponseEntity<>(groups,HttpStatus.OK);
    }

    @GetMapping("/byIdGroup/{groupId}")
    public ResponseEntity<List<UserGroup>> getUserByGroup(@PathVariable Long groupId){
        List<UserGroup> groups = userGroupServices.getAllUser(groupId);
        return new ResponseEntity<>(groups,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserGroup>> getAllGroup(){
        List<UserGroup> groups = userGroupServices.getAllUsersGroups();
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @PutMapping("/{userGroupId}")
    public ResponseEntity<UserGroup> updateGroup(@PathVariable Long userGroupId, @RequestBody UserGroup userGroup){
        return userGroupServices.updateUserGroup(userGroup).map(userGroup1 -> new ResponseEntity<>(userGroup1,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{userGroupId}")
    public ResponseEntity deleteGroup(@PathVariable Long userGroupId){
        if (userGroupServices.deleteUserGroup(userGroupId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
