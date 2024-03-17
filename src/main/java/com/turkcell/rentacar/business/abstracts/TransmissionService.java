package com.turkcell.rentacar.business.abstracts;


import com.turkcell.rentacar.entities.concretes.Transmission;

import java.util.List;

public interface TransmissionService {
    void add(Transmission transmission);
    List<Transmission> getAll();
    Transmission getById(int id);
    void update(int id,Transmission transmission);
    void delete (int id);
}
