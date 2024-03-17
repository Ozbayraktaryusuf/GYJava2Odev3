package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.turkcell.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TransmissionManager implements TransmissionService {
    private TransmissionRepository transmissionRepository;
    @Override
    public void add(Transmission transmission) {

        this.transmissionRepository.save(transmission);
    }

    @Override
    public List<Transmission> getAll() {

        return this.transmissionRepository.findAll();
    }

    @Override
    public Transmission getById(int id) {
        Optional<Transmission> existsTransmission= transmissionRepository.findById(id);
        if (existsTransmission.isPresent()){
            return existsTransmission.get();
        }
        else {
            throw new FindException("Veri tabanında bu ID'ye karşılık veri mevcut değil");
        }
    }

    @Override
    public void update(int id, Transmission transmission) {
        Optional<Transmission> existsTransmission= transmissionRepository.findById(id);
        if (existsTransmission.isPresent()){
            existsTransmission.get().setName(transmission.getName());
            existsTransmission.get().setUpdatedDate(transmission.getUpdatedDate());

            this.transmissionRepository.save(existsTransmission.get());
        }
        else {
            throw new FindException("Veri tabanında bu ID'ye karşılık veri mevcut değil");
        }

    }

    @Override
    public void delete(int id) {
        Optional<Transmission> existsTransmission= transmissionRepository.findById(id);
        if (existsTransmission.isPresent()){
            this.transmissionRepository.deleteById(id);
        }
        else {
            throw new FindException("Veri tabanında bu ID'ye karşılık veri mevcut değil");
        }
    }
}
