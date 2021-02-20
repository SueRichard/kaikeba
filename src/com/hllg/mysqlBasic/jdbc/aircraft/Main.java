package com.hllg.mysqlBasic.jdbc.aircraft;

import com.hllg.mysqlBasic.jdbc.aircraft.bean.Flight;
import com.hllg.mysqlBasic.jdbc.aircraft.dao.FlightDao;
import com.hllg.mysqlBasic.jdbc.aircraft.dao.impl.FlightDaoImpl;
import com.hllg.mysqlBasic.jdbc.aircraft.view.View;

import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/20  Sat  12:19
 */
public class Main {
    static View v = new View();
    static FlightDao dao = new FlightDaoImpl();

    public static void main(String[] args) {
        v.welcome();
        boolean flag = true;
        while (flag) {
            v.mainMenu();
            int choice = v.getChoice(6);
            switch (choice) {
                case 0:
                    add();
                    break;
                case 1:
                    displayAll();
                    break;
                case 2:
                    searchByStartTime();
                    break;
                case 3:
                    searchByDestination();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    update();
                    break;
                case 6:
                    flag = false;
                    v.bye();
                    break;
            }
        }
    }

    private static void add() {
        Flight newFlight = v.getNewFlight();
        int add = dao.add(newFlight);
        v.printAddResult(add);
    }

    private static void update() {
        String num = v.getUpdateID();
        int id = 0;
        try {
            id = Integer.parseInt(num);
            Flight flightById = dao.findFlightById(id);
            //flightById == null永远为false，因为在上面方法中我已经创建了对象，并且int值默认值为0
            if (flightById.getDestination() == null) {
                v.printNotFindID();
                return;
            }
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            v.printNotFindID();
        }
        Flight newFlight = v.getNewFlight();
        int update = dao.update(id, newFlight);
        v.printUpdateResult(update);
    }

    private static void delete() {
        String num = v.getDeleteID();
        int id = -1;
        try {
            id = Integer.parseInt(num);
            int delete = dao.delete(id);
            v.printDeleteResult(delete);
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            v.printIncorrectID();
            delete();
        }
    }

    private static void searchByDestination() {
        String destination = v.getDestination();
        List<Flight> flightByDestination = dao.findByDestination(destination);
        v.displayAll(flightByDestination);
    }

    private static void searchByStartTime() {
        String startDate = v.getStartDate();
        List<Flight> flightByStartDate = dao.findByStartDate(startDate);
        v.displayAll(flightByStartDate);
    }

    private static void displayAll() {
        List<Flight> allFlights = dao.findAllFlights();
        v.displayAll(allFlights);
    }
}
