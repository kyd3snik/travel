package com.kyd3snik.travel.model;

import lombok.Data;

import java.util.List;

@Data
public class maxSearchRequest extends minSearchRequest {
    private List<Tag> necessaryTags;
    private List<Country> acceptableCountries;
    private List<City> acceptableCities;
    private List<Entertainment> necessaryEntertainments;
    private int minStar;
    private List<Facility> necessaryFacilities;
}
