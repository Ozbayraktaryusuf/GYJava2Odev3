package com.turkcell.rentacar.api.controllers;


import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.entities.concretes.Transmission;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/transmissions")
@AllArgsConstructor
public class TransmissionController {
    private TransmissionService transmissionService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Transmission transmission){
        this.transmissionService.add(transmission);
    }

    @GetMapping("/getById/{id}")
    public Transmission getById(@PathVariable int id){
        return this.transmissionService.getById(id);
    }

    @GetMapping("/getAll")
    public List<Transmission> getAll(){
        return this.transmissionService.getAll();
    }

    @PostMapping("/update/{id}")
    @Transactional
    public void update(@PathVariable int id,@RequestBody Transmission transmission){
        this.transmissionService.update(id, transmission);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(int id){
        this.transmissionService.delete(id);
    }
}
