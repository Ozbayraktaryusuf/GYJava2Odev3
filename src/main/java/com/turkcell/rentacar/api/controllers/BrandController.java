package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.entities.concretes.Brand;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/brands")
public class BrandController {
    private BrandService brandService; //Ioc
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Brand brand){
        this.brandService.add(brand);
    }

    @GetMapping("/getById/{id}")
    public Brand gsetById(@PathVariable int id){
        return this.brandService.getById(id);
    }

    @GetMapping("/getAll")
    public List<Brand> getAll(){
        return this.brandService.getAll();
    }

    @PostMapping("/update/{id}")
    @Transactional
    public void update(@PathVariable int id,@RequestBody Brand brand){
        this.brandService.update(id, brand);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(int id){
        this.brandService.delete(id);
    }
}
