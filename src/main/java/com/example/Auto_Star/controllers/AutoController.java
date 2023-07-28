package com.example.Auto_Star.controllers;

import com.example.Auto_Star.model.Auto;
import com.example.Auto_Star.repository.AutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController
public class AutoController {
    private final AutoRepository autoRepository;
    @GetMapping("/api/autos")
    public List<Auto> getAllAutos(@RequestParam(required = false) String title) {
        return title != null ? autoRepository.findByName(title) : autoRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id) {
        autoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Error with id " + id));
        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(Auto auto) {
        autoRepository.save(auto);
        return "redirect:/";
    }

    @DeleteMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        autoRepository.deleteById(id);
        return "Auto with will deleted";
    }
    @PutMapping("/product/edit/{id}")
    public Auto edit(@PathVariable Long id, @RequestBody Auto auto){
        Auto rego = autoRepository.findById(id).orElse(null);
        rego.setName(auto.getName());
        rego.setModel(auto.getModel());
        rego.setCity(auto.getCity());
        rego.setOwner(auto.getOwner());
        rego.setPrice(auto.getPrice());
        return autoRepository.save(rego);
    }
}
