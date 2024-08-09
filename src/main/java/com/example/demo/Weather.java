package com.example.demo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Weather {
    public Weather() {
    }

    public Weather(Long id, int temperature, Cloudiness clouds, String city) {
        this.id = id;
        this.temperature = temperature;
        this.clouds = clouds;
        this.city = city;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int temperature;
    Cloudiness clouds;
    String city;
}

enum Cloudiness {
    SUNNY,
    PARTIALLY,
    CLOUDED
}