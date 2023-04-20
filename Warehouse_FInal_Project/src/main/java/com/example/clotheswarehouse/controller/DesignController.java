package com.example.clotheswarehouse.controller;

import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.clotheswarehouse.model.Brand;
import com.example.clotheswarehouse.model.Brand.BrandName;

import com.example.clotheswarehouse.repository.BrandRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/design")
public class DesignController {

    @Autowired
    private BrandRepository brandRepository;

    @GetMapping
    public String design() {
        return "design";
    }

    @ModelAttribute
    public void brandnames(Model model) {
        var brandnames = EnumSet.allOf(Brand.BrandName.class);
        model.addAttribute("brandnames", brandnames);
        log.info("brandnames converted to string:  {}", brandnames);
    }

    @ModelAttribute
    public Brand brand() {
        return Brand
                .builder()
                .build();
    }

    @PostMapping
    public String processBrandAddition(@Valid Brand brand, BindingResult result) {
        if (result.hasErrors()) {
            return "design";

        }
        log.info("Processing brand: {}", brand);
        brandRepository.save(brand);
        return "redirect:/brandlist";
    }

    @PostMapping("/deleteAllBrands")
    public String processFightersDeletion() {
        log.info("Deleting all brands for user: {}");
        brandRepository.deleteAll();
        return "redirect:/design";
    }

}
