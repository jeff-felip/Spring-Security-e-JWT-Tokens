package com.example.cardapio.controller;

import com.example.cardapio.domain.food.Food;
import com.example.cardapio.repositories.FoodRepository;
import com.example.cardapio.domain.food.FoodRequestDTO;
import com.example.cardapio.domain.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        this.repository.save(foodData);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<FoodResponseDTO>> getAll(){
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return ResponseEntity.ok(foodList);
    }
}
