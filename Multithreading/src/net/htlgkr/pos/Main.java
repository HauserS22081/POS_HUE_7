package net.htlgkr.pos;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Formatter formatter = d -> String.format("Driver: %s %s | Team: %s | Number: %d | LapTime: %d ms | Penalties: %d", d.getName(), d.getLastname(), d.getTeam(), d.getNumber(), d.getLapTime(), d.getPenalties());

        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver("Max", "Verstappen", "Red Bull", 1, formatter));
        drivers.add(new Driver("Charles", "Leclerc", "Ferrari", 16, formatter));
        drivers.add(new Driver("Lewis", "Hamilton", "Mercedes", 44, formatter));
        drivers.add(new Driver("Lando", "Norris", "McLaren", 4, formatter));
        drivers.add(new Driver("George", "Russell", "Mercedes", 63, formatter));
        drivers.add(new Driver("Oscar", "Piastri", "McLaren", 81, formatter));
        drivers.add(new Driver("Sergio", "Pérez", "Red Bull", 11, formatter));
        drivers.add(new Driver("Carlos", "Sainz Jr.", "Ferrari", 55, formatter));
        drivers.add(new Driver("Fernando", "Alonso", "Aston Martin", 14, formatter));
        drivers.add(new Driver("Esteban", "Ocon", "Alpine", 31, formatter));
        drivers.add(new Driver("Pierre", "Gasly", "Alpine", 10, formatter));
        drivers.add(new Driver("Yuki", "Tsunoda", "RB", 22, formatter));
        drivers.add(new Driver("Lance", "Stroll", "Aston Martin", 18, formatter));
        drivers.add(new Driver("Valtteri", "Bottas", "Kick Sauber", 77, formatter));
        drivers.add(new Driver("Guanyu", "Zhou", "Kick Sauber", 24, formatter));
        drivers.add(new Driver("Alex", "Albon", "Williams", 23, formatter));
        drivers.add(new Driver("Nico", "Hülkenberg", "Haas", 27, formatter));
        drivers.add(new Driver("Liam", "Lawson", "RB", 30, formatter));
        drivers.add(new Driver("Oliver", "Bearman", "Haas", 50, formatter));
        drivers.add(new Driver("Franco", "Colapinto", "Williams", 43, formatter));


        for (Driver driver : drivers) {
            driver.drive();
        }

        for (Driver driver : drivers) {
            System.out.println(driver.toString());
        }


    }
}
