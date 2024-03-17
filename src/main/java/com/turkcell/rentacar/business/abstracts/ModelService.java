package com.turkcell.rentacar.business.abstracts;


import com.turkcell.rentacar.entities.concretes.Model;

import java.util.List;

public interface ModelService {
    void add(Model model);
    List<Model> getAll();
    Model getById(int id);
    void update(int id,Model model);
    void delete (int id);
}

