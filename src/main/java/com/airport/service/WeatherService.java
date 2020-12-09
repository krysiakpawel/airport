package com.airport.service;

import com.airport.config.DbManager;
import com.airport.domain.weather.Weather;
import com.airport.domain.weather.dao.WeatherDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.Statement;

@Service
public class WeatherService {

    @Autowired
    private WeatherDao weatherDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherDao.class);

    public Weather saveWeather(final Weather weather) {
        if (weather != null) {
            return weatherDao.save(weather);
        } else {
            return new Weather();
        }
    }

    public void deleteWeather(Long id) {
        try {
            weatherDao.deleteById(id);
        } catch (Exception e) {
            LOGGER.error("Could not find weather record with id: " + id + ". Error: " + e.getMessage());
        }
    }

    public Weather getLatestWeather() {

        try {
            DbManager dbManager = DbManager.getInstance();

            String sqlQueryLatestWeather = "SELECT * FROM weather ORDER BY weather_id DESC LIMIT 1;";
            Statement statement = dbManager.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQueryLatestWeather);
            resultSet.next();
            return new Weather(
                    resultSet.getDouble("wind_speed_m_per_sec"),
                    resultSet.getInt("wind_dir"),
                    resultSet.getDouble("temperature"));

        } catch (Exception e) {
            LOGGER.error("Error while getting latest weather: " + e.getMessage());
            return new Weather();

        }
    }
}
