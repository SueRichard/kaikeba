package com.hllg.mysqlBasic.jdbc.aircraft.dao.impl;

import com.hllg.mysqlBasic.jdbc.aircraft.bean.Flight;
import com.hllg.mysqlBasic.jdbc.aircraft.dao.FlightDao;
import com.hllg.mysqlBasic.jdbc.aircraft.utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/19  Fri  23:27
 */
public class FlightDaoImpl implements FlightDao {

    @Override
    public int add(Flight flight) {
        String sql = "insert flight(num,destination,startDate) values(?,?,?)";
        List parameters = new ArrayList();
        //放值顺序要和sql语句参数一致，注意！
        parameters.add(flight.getNum());
        parameters.add(flight.getDestination());
        parameters.add(flight.getStartDate());
        int add = DBUtil.update(sql, parameters);
        //这里关闭，是为了大数据量，调用关闭，连接池不会真的关了，方便下次使用
        DBUtil.closeAll();
        return add;
    }

    @Override
    public int delete(int id) {
        String sql = "delete from flight where id=?";
        List parameters = new ArrayList();
        parameters.add(id);
        int delete = 0;
        try {
            delete = DBUtil.update(sql, parameters);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("id输入不合法");
        }
        DBUtil.closeAll();
        return delete;
    }

    @Override
    public int update(int id, Flight newFlight) {
        String sql = "update flight set num=? , destination=? , startDate = ? where id=?";
        List parameters = new ArrayList();
        parameters.add(newFlight.getNum());
        parameters.add(newFlight.getDestination());
        parameters.add(newFlight.getStartDate());
        parameters.add(id);
        int update = 0;
        try {
            update = DBUtil.update(sql, parameters);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("请核对id号，以及对应数据类型");
        }
        DBUtil.closeAll();
        return update;
    }

    @Override
    public List<Flight> findAllFlights() {
        String sql = "select * from flight";
        ResultSet resultSet = DBUtil.queryAll(sql);
        List<Flight> allFlights = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setId(resultSet.getInt("id"));
                flight.setNum(resultSet.getInt("num"));
                flight.setDestination(resultSet.getString("destination"));
                flight.setStartDate(resultSet.getDate("startDate"));
                allFlights.add(flight);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeAll();
        }
        return allFlights;
    }

    @Override
    public Flight findFlightById(int id) {
        String sql = "select * from flight where id=?";
        List parameter = new ArrayList();
        parameter.add(id);
        ResultSet resultSet = DBUtil.queryByConditions(sql, parameter);
        Flight flight = new Flight();
        try {
            while (resultSet.next()) {
                flight.setId(resultSet.getInt("id"));
                flight.setNum(resultSet.getInt("num"));
                flight.setDestination(resultSet.getString("destination"));
                flight.setStartDate(resultSet.getDate("startDate"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeAll();
        }
        return flight;
    }

    @Override
    public List<Flight> findByDestination(String destination) {
        List<Flight> flights = new ArrayList<>();
        String sql = "select * from flight where destination=?";
        List parameter = new ArrayList();
        parameter.add(destination);
        ResultSet resultSet = DBUtil.queryByConditions(sql, parameter);
        try {
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setId(resultSet.getInt("id"));
                flight.setNum(resultSet.getInt("num"));
                flight.setDestination(resultSet.getString("destination"));
                flight.setStartDate(resultSet.getDate("startDate"));
                flights.add(flight);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeAll();
        }
        return flights;
    }

    @Override
    public List<Flight> findByStartDate(String startDate) {
        List<Flight> flights = new ArrayList<>();
        String sql = "select * from flight where startDate=?";
        List parameter = new ArrayList();
        parameter.add(startDate);
        ResultSet resultSet = DBUtil.queryByConditions(sql, parameter);
        try {
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setId(resultSet.getInt("id"));
                flight.setNum(resultSet.getInt("num"));
                flight.setDestination(resultSet.getString("destination"));
                flight.setStartDate(resultSet.getDate("startDate"));
                flights.add(flight);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeAll();
        }
        return flights;
    }
}
