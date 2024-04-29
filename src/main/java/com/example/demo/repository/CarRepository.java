package com.example.demo.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.demo.model.CarModel;

public interface CarRepository extends ElasticsearchRepository<CarModel, String> {

    List<CarModel> findAllByBrand(String brand);
}
