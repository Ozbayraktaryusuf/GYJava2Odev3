package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.dataAccess.abstracts.FuelRepository;
import com.turkcell.rentacar.entities.concretes.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FuelManager implements FuelService {
    private FuelRepository fuelRepository;
    @Override
    public void add(Fuel fuel) {
        this.fuelRepository.save(fuel);
    }

    @Override
    public Fuel getById(int id) {
        Optional<Fuel> existsFuel = this.fuelRepository.findById(id);
        if (existsFuel.isPresent()){
            return existsFuel.get();
        }
        else {
            throw new FindException("Veri tabanında bu idye karşılık bir veri mevcut değil");
        }
    }

    @Override
    public List<Fuel> getAll() {
        return this.fuelRepository.findAll();
    }

    @Override
    public void update(int id, Fuel fuel) {
        Optional<Fuel> existsFuel = this.fuelRepository.findById(id);
        if (existsFuel.isPresent()){
            existsFuel.get().setName(fuel.getName());
            existsFuel.get().setUpdatedDate(fuel.getUpdatedDate());

            this.fuelRepository.save(existsFuel.get());
        }
        else {
            throw new FindException("Veri tabanında bu idye karşılık bir veri mevcut değil");
        }
    }

    @Override
    public void delete(int id) {
        Optional<Fuel> existsFuel = this.fuelRepository.findById(id);
        if (existsFuel.isPresent()){
            this.fuelRepository.deleteById(id);
        }
        else {
            throw new FindException("Veri tabanında bu idye karşılık bir veri mevcut değil");
        }

    }
}
