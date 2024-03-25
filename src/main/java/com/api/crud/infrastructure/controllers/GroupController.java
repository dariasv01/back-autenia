package com.api.crud.infrastructure.controllers;

import com.api.crud.application.services.GroupServices;
import com.api.crud.domain.models.Group;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    private final GroupServices groupServices;

    public GroupController(GroupServices groupServices) {
        this.groupServices = groupServices;
    }

    @PostMapping
    public ResponseEntity<Group> createGroup(@RequestBody Group group){
        Group createdSpent = groupServices.createGroup(group);
        return new ResponseEntity<>(createdSpent, HttpStatus.CREATED);
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<Group> getGroupById(@PathVariable Long groupId){
        return groupServices.getGroup(groupId).map(group -> new ResponseEntity<>(group,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/byIdUser/{userId}")
    public ResponseEntity<List<Group>> getGroupByUser(@PathVariable Long userId){
        List<Group> groups = groupServices.getGroupsByUserId(userId);
        return new ResponseEntity<>(groups,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Group>> getAllGroup(){
        List<Group> groups = groupServices.getAllGroup();
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @PutMapping("/{spentId}")
    public ResponseEntity<Group> updateGroup(@PathVariable Long spentId, @RequestBody Group spent){
        return groupServices.updateGroup(spent,spentId).map(spent1 -> new ResponseEntity<>(spent1,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{spentId}")
    public ResponseEntity deleteGroup(@PathVariable Long spentId){
        if (groupServices.deleteGroup(spentId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
