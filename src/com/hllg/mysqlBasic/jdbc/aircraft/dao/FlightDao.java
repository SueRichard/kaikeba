package com.hllg.mysqlBasic.jdbc.aircraft.dao;

import com.hllg.mysqlBasic.jdbc.aircraft.bean.Flight;

import java.util.Date;
import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/19  Fri  23:26
 */
public interface FlightDao {
    int add(Flight flight);

    int delete(int id);

    int update(int id, Flight newFlight);

    List<Flight> findAllFlights();

    Flight findFlightById(int id);

    List<Flight> findByDestination(String destination);

    List<Flight> findByStartDate(String startDate);
}
