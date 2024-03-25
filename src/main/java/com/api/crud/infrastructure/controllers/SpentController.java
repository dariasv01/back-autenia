package com.api.crud.infrastructure.controllers;

import com.api.crud.application.services.SpentServices;
import com.api.crud.domain.models.Spent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spents")
public class SpentController {

    private final SpentServices spentServices;

    public SpentController(SpentServices spentServices) {
        this.spentServices = spentServices;
    }

    @PostMapping
    public ResponseEntity<Spent> createSpent(@RequestBody Spent spent){
        Spent createdSpent = spentServices.createSpents(spent);
        return new ResponseEntity<>(createdSpent, HttpStatus.CREATED);
    }

    @GetMapping("/{spentId}")
    public ResponseEntity<Spent> getSpentById(@PathVariable Long spentId){
        return spentServices.getSpent(spentId).map(spent -> new ResponseEntity<>(spent,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Spent>> getAllSpent(){
        List<Spent> spents = spentServices.getAllSpents();
        return new ResponseEntity<>(spents, HttpStatus.OK);
    }

    @GetMapping("/byIdGroup/{groupId}")
    public ResponseEntity<List<Spent>> getGroupByUser(@PathVariable Long groupId){
        List<Spent> spents = spentServices.getSpentsByGroupId(groupId);
        return new ResponseEntity<>(spents,HttpStatus.OK);
    }
    @GetMapping("/byIdGroup/{groupId}/byIdUser/{userId}")
    public ResponseEntity<List<Spent>> getSpentByGroupAndUser(@PathVariable Long groupId, @PathVariable Long userId){
        List<Spent> spents = spentServices.getSpentsByGroupIdAndUserId(groupId,userId);
        return new ResponseEntity<>(spents,HttpStatus.OK);
    }

    @PutMapping("/{spentId}")
    public ResponseEntity<Spent> updateSpent(@PathVariable Long spentId, @RequestBody Spent spent){
        return spentServices.updateSpents(spent,spentId).map(spent1 -> new ResponseEntity<>(spent1,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{spentId}")
    public ResponseEntity deleteSpent(@PathVariable Long spentId){
        if (spentServices.deleteSpent(spentId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
