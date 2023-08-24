package com.example.transporttrade.service;

import com.example.transporttrade.entity.Transport;
import com.example.transporttrade.repository.TransportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportService {

    private final TransportRepository transportRepository;

    public TransportService(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
    }

    public List<Transport> list() {
        return transportRepository.findAll();
    }

    public void create(Transport transport) {
        transportRepository.save(transport);
    }

    public void delete(Long id) {
        transportRepository.deleteById(id);
    }

    public Transport getTransportById(long id) {
        Transport transport = null;
        for (int i = 0; i <= list().size(); i++) {
            if (list().get(i).getId() == id) {
                transport = list().get(i);
                return transport;
            }
        }
        return transport;
    }

    public void update(Transport transport) {
        transportRepository.save(transport);
    }

    public List<Transport> search(String keyboard) {
        return transportRepository.findByBrandOrModelOrCategoryOrNumberOrType(keyboard, keyboard, keyboard, keyboard, keyboard);
    }

    public List<Transport> filter(String brand, String model, String category, String number, String year) {
        if(year.isEmpty()) year = "0";
        int numberYear = Integer.parseInt(year);
        return transportRepository.findByBrandOrModelOrCategoryOrNumberOrYear(brand, model, category, number, numberYear);
    }

}

