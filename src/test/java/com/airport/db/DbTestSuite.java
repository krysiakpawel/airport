package com.airport.db;


import com.airport.config.DbManager;
import org.junit.Assert;
import org.junit.Test;
import java.sql.SQLException;

public class DbTestSuite {
    @Test
    public void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        Assert.assertNotNull(dbManager.getConnection());
    }
}