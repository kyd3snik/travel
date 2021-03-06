package com.kyd3snik.travel.repository;

import com.kyd3snik.travel.model.City;
import com.kyd3snik.travel.model.Country;
import com.kyd3snik.travel.model.Hotel;
import com.kyd3snik.travel.model.Resort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ResortRepository extends JpaRepository<Resort, Long> {

    List<Resort> findByHotel(Hotel hotel);

    List<Resort> findByTitleContainingIgnoreCaseAndPurchasedIsFalseAndStartDateAfter(String title, Date minStartDate);

    List<Resort> findByArrivalCityAndPurchasedIsFalseAndStartDateAfter(City city, Date minStartDate);

    List<Resort> findAllByPurchasedFalseAndStartDateAfter(Date minStartDate);

    List<Resort> findByArrivalCity_CountryAndPurchasedFalseAndStartDateAfter(Country country, Date minDate);
}
