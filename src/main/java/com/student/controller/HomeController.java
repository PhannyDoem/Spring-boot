package com.student.controller;

import com.student.model.Home;
import com.student.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @GetMapping("/homes")
    public ResponseEntity<List<Home>> getAllHomes(){
        List<Home> homes = homeService.getAllHomes();
        return ResponseEntity.ok(homes);
    }

    @GetMapping("/home/{id}")
    public ResponseEntity<Home> getHomeById(@PathVariable Long id){
        Optional<Home> home = homeService.getHomeById(id);
        return home.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElse(
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/home")
    public ResponseEntity<Home> saveHome(@RequestBody Home home){
        Home savedHome = homeService.saveHome(home);
        return new ResponseEntity<>(savedHome, HttpStatus.CREATED);
    }

    @PutMapping("/home/{id}")
    public ResponseEntity<Home> updateHome(@PathVariable Long id, @RequestBody Home homeDetails){
        Home updatedHome = homeService.updateHome(id, homeDetails);
        return updatedHome != null ? new ResponseEntity<>(updatedHome, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/home/{id}")
    public ResponseEntity<String> deleteHome(@PathVariable Long id){
        String response = homeService.deleteHome(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
