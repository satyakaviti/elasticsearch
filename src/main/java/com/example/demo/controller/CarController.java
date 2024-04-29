package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CarModel;
import com.example.demo.repository.CarRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarRepository carRepository;

    @PostMapping
    public void save(@RequestBody CarModel car) {
        carRepository.save(car);
    }

    @GetMapping("/{id}")
    public CarModel findById(@PathVariable String id) {
        return carRepository.findById(id).orElse(null);
    }

    @GetMapping
    public Iterable<CarModel> findAll() {
        return carRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        carRepository.deleteById(id);
    }

    @PutMapping
    public void update(@RequestBody CarModel car) {
        carRepository.save(car);
    }

    @GetMapping("/find")
    public List<CarModel> findByBrand(@RequestParam String brand) {
        return carRepository.findAllByBrand(brand);
    }
}
