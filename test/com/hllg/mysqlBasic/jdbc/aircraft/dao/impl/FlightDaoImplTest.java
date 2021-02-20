package com.hllg.mysqlBasic.jdbc.aircraft.dao.impl;

import com.hllg.mysqlBasic.jdbc.aircraft.bean.Flight;
import com.hllg.mysqlBasic.jdbc.aircraft.dao.FlightDao;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/20  Sat  09:40
 */
public class FlightDaoImplTest {

    @Test
    public void add() {
        FlightDao dao = new FlightDaoImpl();
        Flight f = new Flight(453,"北京", new Date());
        int add = dao.add(f);
        System.out.println(add);
    }

    @Test
    public void delete() {
        FlightDao dao = new FlightDaoImpl();
        int delete = dao.delete(9);
        System.out.println(delete);
    }

    @Test
    public void update() {
        FlightDao dao = new FlightDaoImpl();
        Flight newFlight = new Flight(12,"铜陵", new Date());
        int update = dao.update(10,newFlight);
        System.out.println(update);
    }

    @Test
    public void findAllFlights() {
        FlightDao dao = new FlightDaoImpl();
        List<Flight> allFlights = dao.findAllFlights();
        for (Flight allFlight : allFlights) {
            System.out.println(allFlight);
        }
    }

    @Test
    public void findFlightById() {
        FlightDao dao = new FlightDaoImpl();
        Flight flight = dao.findFlightById(1);
        System.out.println(flight);
    }

    @Test
    public void findByDestination() {
        FlightDao dao = new FlightDaoImpl();
        List<Flight> flights = dao.findByDestination("北京");
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }

    @Test
    public void findByStartDate() {
        FlightDao dao = new FlightDaoImpl();
        /**
         * 插入日期出现问题，尝试用 SimpleDateFormat,但是java中的月份从0开始，麻烦，
         * 修改参数类型，由原来的date换成string
         */
        List<Flight> flights = dao.findByStartDate("2021-2-20");
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }
}