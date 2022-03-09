package com.techelevator.tenmo.dao;

public class JdbcAccountDao {


    @Override
    public Account getBalance(long cityId) {
        City city = null;
        String sql = "SELECT city_id, city_name, state_abbreviation, population, area " +
                "FROM city " +
                "WHERE city_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, cityId);
        if (results.next()) {
            city = mapRowToCity(results);
        }
        return city;
    }


}
