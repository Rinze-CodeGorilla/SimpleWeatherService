package com.example.demo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WeatherController {

    private final WeatherRepository repository;

    WeatherController(WeatherRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    List<Weather> getWeather() {
        return repository.findAllBy();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    Weather addWeather(@Valid @RequestBody WeatherRequest request) {
        Weather w = new Weather(
                null,
                request.temperature(),
                request.cloudiness,
                request.city());
        return repository.save(w);
    }

    @GetMapping("/{city}")
    Weather getWeather(@Size(min=3) @PathVariable String city) {
        return repository.findFirstByCityOrderByTemperatureDesc(city);
    }

    record WeatherRequest(
            @Min(20) int temperature,
            Cloudiness cloudiness,
            @NotNull @Pattern(regexp = "[A-Z]\\w+") String city
    ) {}
}
