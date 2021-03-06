package com.kyd3snik.travel.configuration;

import com.kyd3snik.travel.model.*;
import com.kyd3snik.travel.repository.*;
import com.kyd3snik.travel.util.DateUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

@Configuration
class MainConfiguration {
    @Bean
    public CommandLineRunner test(HotelRepository hotelRepository, HotelRoomRepository hotelRoomRepository,
                                  ResortRepository resortRepository, TagRepository tagRepository,
                                  UserRepository userRepository, CityRepository cityRepository,
                                  CountryRepository countryRepository, EntertainmentRepository entertainmentRepository,
                                  FacilityRepository facilityRepository) {
        return args -> {
            Tag tag1 = tagRepository.save(new Tag(0, "Горы"));
            Tag tag2 = tagRepository.save(new Tag(0, "Море"));
            Tag tag3 = tagRepository.save(new Tag(0, "Пустыня"));
            Tag tag4 = tagRepository.save(new Tag(0, "Сафари"));
            Tag tag5 = tagRepository.save(new Tag(0, "Архитектура"));
            Tag tag6 = tagRepository.save(new Tag(0, "Столица"));
            Tag tag7 = tagRepository.save(new Tag(0, "Экскурсии"));
            Facility facility1 = facilityRepository.save(new Facility(0, "душ в номере"));
            Facility facility2 = facilityRepository.save(new Facility(0, "туалет в номере"));
            Facility facility3 = facilityRepository.save(new Facility(0, "кухня"));
            Facility facility4 = facilityRepository.save(new Facility(0, "кондиционер"));
            Facility facility5 = facilityRepository.save(new Facility(0, "Wi-Fi"));
            Facility facility6 = facilityRepository.save(new Facility(0, "бассейн"));
            Entertainment entertainment1 = entertainmentRepository.save(new Entertainment(0, "кино"));
            Entertainment entertainment2 = entertainmentRepository.save(new Entertainment(0, "рестораны"));
            Entertainment entertainment3 = entertainmentRepository.save(new Entertainment(0, "рыбалка"));
            Entertainment entertainment4 = entertainmentRepository.save(new Entertainment(0, "море"));
            Entertainment entertainment5 = entertainmentRepository.save(new Entertainment(0, "охота"));
            Entertainment entertainment6 = entertainmentRepository.save(new Entertainment(0, "экскурсии"));
            Entertainment entertainment7 = entertainmentRepository.save(new Entertainment(0, "аквапарк"));
            Entertainment entertainment8 = entertainmentRepository.save(new Entertainment(0, "музеи"));
            Country country1 = countryRepository.save(new Country(0, "Россия", "крупнейшая страна мира, расположенная в Восточной Европе и Северной Азии", Collections.emptyList()));
            Country country2 = countryRepository.save(new Country(0, "Германия", "государство в Западной Европе с лесами, реками, горными хребтами и пляжными курортами Северного моря", Collections.emptyList()));
            Country country3 = countryRepository.save(new Country(0, "Марокко", "страна в Северной Африке, омываемая водами Атлантического океана и Средиземного моря", Collections.emptyList()));
            Country country4 = countryRepository.save(new Country(0, "Турция", "государство на юго-востоке Европы и юго-западе Азии, культура которого сочетает древнегреческие, персидские, римские, византийские и османские традиции", Collections.emptyList()));
            City city1 = cityRepository.save(new City(0, "Москва", country1, List.of(entertainment1, entertainment2, entertainment6, entertainment8), Collections.emptyList(), Collections.emptyList()));
            City city2 = cityRepository.save(new City(0, "Сочи", country1, List.of(entertainment4, entertainment6, entertainment7), Collections.emptyList(), Collections.emptyList()));
            City city3 = cityRepository.save(new City(0, "Берлин", country2, List.of(entertainment1, entertainment2, entertainment8), Collections.emptyList(), Collections.emptyList()));
            City city4 = cityRepository.save(new City(0, "Воронеж", country1, List.of(entertainment1, entertainment2), Collections.emptyList(), Collections.emptyList()));
            City city5 = cityRepository.save(new City(0, "Рабат", country3, List.of(entertainment2, entertainment4, entertainment6), Collections.emptyList(), Collections.emptyList()));
            City city6 = cityRepository.save(new City(0, "Анкара", country4, List.of(entertainment2, entertainment6, entertainment8), Collections.emptyList(), Collections.emptyList()));
            City city7 = cityRepository.save(new City(0, "Измир", country4, List.of(entertainment2, entertainment6, entertainment4), Collections.emptyList(), Collections.emptyList()));
            HotelRoom hotelRoom1 = hotelRoomRepository.save(new HotelRoom(0, (byte) 1, List.of(facility5), 1100));
            HotelRoom hotelRoom2 = hotelRoomRepository.save(new HotelRoom(0, (byte) 2, List.of(facility5), 2000));
            HotelRoom hotelRoom3 = hotelRoomRepository.save(new HotelRoom(0, (byte) 2, List.of(facility5, facility4), 2300));
            HotelRoom hotelRoom4 = hotelRoomRepository.save(new HotelRoom(0, (byte) 3, List.of(facility5, facility4, facility2), 4500));
            HotelRoom hotelRoom5 = hotelRoomRepository.save(new HotelRoom(0, (byte) 2, List.of(facility5, facility4, facility2, facility1), 4000));
            HotelRoom hotelRoom6 = hotelRoomRepository.save(new HotelRoom(0, (byte) 2, List.of(facility5, facility4, facility2, facility1, facility6), 4500));
            HotelRoom hotelRoom7 = hotelRoomRepository.save(new HotelRoom(0, (byte) 2, List.of(facility5, facility4, facility6), 4800));
            HotelRoom hotelRoom8 = hotelRoomRepository.save(new HotelRoom(0, (byte) 3, List.of(facility5, facility4, facility6), 6000));
            HotelRoom hotelRoom9 = hotelRoomRepository.save(new HotelRoom(0, (byte) 2, List.of(facility5, facility4, facility2, facility1, facility6), 5000));
            HotelRoom hotelRoom10 = hotelRoomRepository.save(new HotelRoom(0, (byte) 2, List.of(facility3, facility4, facility2, facility1, facility6), 4000));
            Hotel hotel1 = hotelRepository.save(new Hotel(0, "Гостиница Останкино", city1, "Ботаническая ул., 29, к. 1", (byte) 3, List.of(hotelRoom1, hotelRoom2, hotelRoom3), Collections.emptyList()));
            Hotel hotel2 = hotelRepository.save(new Hotel(0, "Arbat House", city1, "Скатертный пер., 13", (byte) 4, List.of(hotelRoom4, hotelRoom5), Collections.emptyList()));
            Hotel hotel3 = hotelRepository.save(new Hotel(0, "Vienna House Andel’s Berlin", city3, "Landsberger Allee 106", (byte) 4, List.of(hotelRoom6), Collections.emptyList()));
            Hotel hotel4 = hotelRepository.save(new Hotel(0, "ibis Rabat Agdal", city5, "Avenue Haj Ahmed Charkaoui, Place De La Gare", (byte) 3, List.of(hotelRoom7, hotelRoom8), Collections.emptyList()));
            Hotel hotel5 = hotelRepository.save(new Hotel(0, "Hilton Izmir", city7, "İsmet Kaptan, Gazi Osman Paşa Blv. No:7", (byte) 5, List.of(hotelRoom9), Collections.emptyList()));
            Hotel hotel6 = hotelRepository.save(new Hotel(0, "Sanremo", city2, "ул. Черноморская, 13Г", (byte) 4, List.of(hotelRoom10), Collections.emptyList()));
            Resort resort1 = resortRepository.save(new Resort(0, "Поездка в Москву", "Непродолжительное путешествие в столицу России с экскурсией", city4, city1, List.of(tag6, tag7), hotel1, 3, DateUtil.getDate(2020, 10, 20), DateUtil.getDate(2020, 10, 23), 8300, (byte) 1, false));
            Resort resort2 = resortRepository.save(new Resort(0, "Поездка в столицу Марокко", "Увлекательное путешествие", city1, city5, List.of(tag6, tag7, tag2, tag5), hotel4, 7, DateUtil.getDate(2020, 7, 5), DateUtil.getDate(2020, 7, 12), 52000, (byte) 2, false));
            Resort resort3 = resortRepository.save(new Resort(0, "Отпуск в Турции", "Великолепный отдых на берегу Эгейского моря", city1, city7, List.of(tag2, tag5), hotel5, 5, DateUtil.getDate(2020, 7, 9), DateUtil.getDate(2020, 7, 14), 45000, (byte) 2, false));
            Resort resort4 = resortRepository.save(new Resort(0, "Отпуск в Сочи", "Поездка в Сочи", city1, city2, List.of(tag1, tag2, tag7), hotel6, 7, DateUtil.getDate(2020, 12, 5), DateUtil.getDate(2020, 12, 12), 42000, (byte) 2, false));
            Resort resort5 = resortRepository.save(new Resort(0, "Поездка в Москву", "Непродолжительное путешествие в столицу России с экскурсией", city4, city1, List.of(tag6, tag7), hotel1, 3, DateUtil.getDate(2020, 5, 28), DateUtil.getDate(2020, 5, 31), 9400, (byte) 1, false));
            User user1 = userRepository.save(new User(0, "First name", "Last name", "Middle name", Calendar.getInstance().getTime(), true, true, "email@mail.com", "$2a$10$19un6NQ9sFWAZ4D9S78mN.v1idUEJaLz4/4cQ02BFMVQIRJIotd6a", 0, User.ROLE_MODERATOR, city1, false));
            User user2 = userRepository.save(new User(0, "First name another", "Last name another", "Middle name another", Calendar.getInstance().getTime(), true, false, "example@mail.com", "$2a$10$19un6NQ9sFWAZ4D9S78mN.v1idUEJaLz4/4cQ02BFMVQIRJIotd6a", 0, User.ROLE_USER, city2, true));
        };
    }

}