package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    @Override
    public void add(Brand brand) {
        this.brandRepository.save(brand);
    }

    @Override
    public Brand getById(int id) {
        Optional<Brand> existsBrand = this.brandRepository.findById(id);
        if (existsBrand.isPresent()){
            return existsBrand.get();
        }
        else {
            throw new FindException("Veri tabanında bu idye karşılık bir veri mevcut değil");
        }
    }

    @Override
    public List<Brand> getAll() {
        return this.brandRepository.findAll();
    }

    @Override
    public void update(int id, Brand brand) {
        Optional<Brand> existsBrand = this.brandRepository.findById(id);
        if (existsBrand.isPresent()){
            existsBrand.get().setName(brand.getName());
            existsBrand.get().setUpdatedDate(brand.getUpdatedDate());

            this.brandRepository.save(existsBrand.get());
        }
        else {
            throw new FindException("Veri tabanında bu idye karşılık bir veri mevcut değil");
        }
    }

    @Override
    public void delete(int id) {
        Optional<Brand> existsBrand = this.brandRepository.findById(id);
        if (existsBrand.isPresent()){
            this.brandRepository.deleteById(id);
        }
        else {
            throw new FindException("Veri tabanında bu idye karşılık bir veri mevcut değil");
        }

    }
}


//ioc nedir?