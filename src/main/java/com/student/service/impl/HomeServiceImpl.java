package com.student.service.impl;

import com.student.model.Home;
import com.student.repository.HomeRepository;
import com.student.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeRepository homeRepository;

    @Override
    public Home saveHome(Home home) {
        return homeRepository.save(home);
    }

    @Override
    public Optional<Home> getHomeById(Long id) {
        return homeRepository.findById(id);
    }

    @Override
    public List<Home> getAllHomes() {
        return homeRepository.findAll();
    }

    @Override
    public Home updateHome(long id, Home home) {
        return homeRepository.findById(id)
                .map(home1 -> {
                    home1.setModel(home.getModel());
                    home1.setPrice(home.getPrice());
                    return homeRepository.save(home1);
                }).orElse( null);
    }

    @Override
    public String deleteHome(long id) {
        homeRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
