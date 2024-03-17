package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.entities.concretes.Model;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/models")
@AllArgsConstructor
public class ModelController {
    private ModelService modelService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Model model){
        this.modelService.add(model);
    }
    @GetMapping("/getById/{id}")
    public Model getById(@PathVariable int id){
        return this.modelService.getById(id);
    }

    @GetMapping("/getAll")
    public List<Model> getAll(){
        return this.modelService.getAll();
    }

    @PostMapping("/update/{id}")
    @Transactional
    public void update(@PathVariable int id,@RequestBody Model model){
        this.modelService.update(id, model);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(int id){
        this.modelService.delete(id);
    }


}
