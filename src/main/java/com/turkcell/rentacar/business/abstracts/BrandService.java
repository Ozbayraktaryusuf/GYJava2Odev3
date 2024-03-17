package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.entities.concretes.Brand;

import java.util.List;

public interface BrandService {
    void add(Brand brand);
    List<Brand> getAll();
    Brand getById(int id);
    void update(int id,Brand brand);
    void delete (int id);
}
