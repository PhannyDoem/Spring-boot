package com.student.service;

import com.student.model.Home;

import java.util.List;
import java.util.Optional;

public interface HomeService {
    Home saveHome(Home home);

    Optional<Home> getHomeById(Long id);

    List<Home> getAllHomes();
    Home updateHome(long id, Home home);

    String deleteHome(long id);
}
