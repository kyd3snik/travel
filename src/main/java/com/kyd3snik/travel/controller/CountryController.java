package com.kyd3snik.travel.controller;

import com.kyd3snik.travel.model.Country;
import com.kyd3snik.travel.services.AuthService;
import com.kyd3snik.travel.services.CityService;
import com.kyd3snik.travel.services.CountryService;
import com.kyd3snik.travel.services.ResortService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@Controller
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;
    private final ResortService resortService;
    private final CityService cityService;

    public CountryController(CountryService countryService, ResortService resortService, CityService cityService) {
        this.countryService = countryService;
        this.resortService = resortService;
        this.cityService = cityService;
    }

    @GetMapping
    public ModelAndView getCountries() {
        ModelAndView modelAndView = new ModelAndView("countries");
        modelAndView.addObject("countries", countryService.getAll());
        modelAndView.addObject("isModerator",
                AuthService.isAuthenticated() && AuthService.getUser().isModerator());
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView searchByTitle(@RequestParam("search") String title) {
        ModelAndView modelAndView = new ModelAndView("countries");
        modelAndView.addObject("countries", countryService.searchByTitle(title));
        modelAndView.addObject("isModerator",
                AuthService.isAuthenticated() && AuthService.getUser().isModerator());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getCountry(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("country");
        Country country = countryService.getById(id);
        modelAndView.addObject("country", country);
        modelAndView.addObject("resorts", resortService.getResortsInCountry(country));
        modelAndView.addObject("cities", cityService.getAllCitiesInCountry(country));
        modelAndView.addObject("isModerator",
                AuthService.isAuthenticated() && AuthService.getUser().isModerator());
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addCountry() {
        return new ModelAndView("addCountry");
    }

    @PostMapping("/add")
    public ModelAndView addCountry(
            @RequestParam("title") String title,
            @RequestParam("description") String description) {
        ModelAndView modelAndView = new ModelAndView("addCountry");
        countryService.addCountry(new Country(0, title, description, Collections.emptyList()));
        modelAndView.addObject("isSuccessful", true);
        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView deleteCountry(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("deleteCountry");
        Country country = countryService.getById(id);
        modelAndView.addObject("country", country);
        modelAndView.addObject("resorts", resortService.getResortsInCountry(country));
        modelAndView.addObject("cities", cityService.getAllCitiesInCountry(country));
        return modelAndView;
    }

    @PostMapping("/{id}/delete")
    public ModelAndView deleteCountryPost(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("deleteCountry");
        Country country = countryService.getById(id);
        modelAndView.addObject("country", country);
        modelAndView.addObject("resorts", resortService.getResortsInCountry(country));
        modelAndView.addObject("cities", cityService.getAllCitiesInCountry(country));

        try {
            countryService.delete(id);
            modelAndView.addObject("isSuccessful", true);
        } catch (IllegalStateException e) {
            modelAndView.addObject("errorMessage", e.getMessage());
        }
        return modelAndView;
    }

}
