package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.entities.concretes.Fuel;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/fuels")
@AllArgsConstructor
public class FuelController {
    private FuelService fuelService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Fuel fuel){
        this.fuelService.add(fuel);
    }

    @GetMapping("/getById/{id}")
    public Fuel getById(@PathVariable int id){
        return this.fuelService.getById(id);
    }

    @GetMapping("/getAll")
    public List<Fuel> getAll(){
        return this.fuelService.getAll();
    }

    @PostMapping("/update/{id}")
    @Transactional
    public void update(@PathVariable int id,@RequestBody Fuel fuel){
        this.fuelService.update(id, fuel);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(int id){
        this.fuelService.delete(id);
    }
}

