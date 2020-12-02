package com.airport.service;

import com.airport.config.DbManager;
import com.airport.domain.weather.Weather;
import com.airport.domain.weather.dao.WeatherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class WeatherService {

    @Autowired
    private WeatherDao weatherDao;

    public Weather saveWeather(final Weather weather){
        return weatherDao.save(weather);
    }
     public void deleteWeather(Long id){
        weatherDao.deleteById(id);
     }

     public Weather getLatestWeather() throws SQLException {

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

         } catch (SQLException e) {
             System.out.println("Error: " + e);
             return new Weather();

         }
     }
}
