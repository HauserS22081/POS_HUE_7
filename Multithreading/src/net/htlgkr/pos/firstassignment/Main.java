package net.htlgkr.pos.firstassignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {

        Formatter formatter = d -> String.format("Driver: %10s %13s | Team: %13s | Number: %3d | LapTime: %15d ms | Penalties: %3d", d.getName(), d.getLastname(), d.getTeam(), d.getNumber(), d.getLapTime(), d.getPenalties());

        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver("Max", "Verstappen", "Red Bull", 1, formatter));
        drivers.add(new Driver("Charles", "Leclerc", "Ferrari", 2, formatter));
        drivers.add(new Driver("Lewis", "Hamilton", "Mercedes", 3, formatter));
        drivers.add(new Driver("Lando", "Norris", "McLaren", 4, formatter));
        drivers.add(new Driver("George", "Russell", "Mercedes", 5, formatter));
        drivers.add(new Driver("Oscar", "Piastri", "McLaren", 6, formatter));
        drivers.add(new Driver("Sergio", "Pérez", "Red Bull", 7, formatter));
        drivers.add(new Driver("Carlos", "Sainz Jr.", "Ferrari", 8, formatter));
        drivers.add(new Driver("Fernando", "Alonso", "Aston Martin", 9, formatter));
        drivers.add(new Driver("Esteban", "Ocon", "Alpine", 10, formatter));
        drivers.add(new Driver("Pierre", "Gasly", "Alpine", 11, formatter));
        drivers.add(new Driver("Yuki", "Tsunoda", "RB", 12, formatter));
        drivers.add(new Driver("Lance", "Stroll", "Aston Martin", 13, formatter));
        drivers.add(new Driver("Valtteri", "Bottas", "Kick Sauber", 14, formatter));
        drivers.add(new Driver("Guanyu", "Zhou", "Kick Sauber", 15, formatter));
        drivers.add(new Driver("Alex", "Albon", "Williams", 16, formatter));
        drivers.add(new Driver("Nico", "Hülkenberg", "Haas", 17, formatter));
        drivers.add(new Driver("Liam", "Lawson", "RB", 18, formatter));
        drivers.add(new Driver("Oliver", "Bearman", "Haas", 19, formatter));
        drivers.add(new Driver("Franco", "Colapinto", "Williams", 20, formatter));

        addPenalties(drivers);

        // Assignment 1
//        for (Driver driver : drivers) {
//            driver.drive();
//        }
//
//        for (Driver driver : drivers) {
//            System.out.println(driver.toString());
//        }


        // Wie viele Fahrer*innen können hier gleichzeitig die Rennstrecke befahren? ExecutorService executor = Executor.newFixedThreadPool(1);
        //    1 Fahrer

        ExecutorService executorService = Executors.newFixedThreadPool(4);


        // Assignment 2
//        ArrayList<RunnableTask> tasks = new ArrayList<>();
//
//        for (Driver driver : drivers) {
//            tasks.add(new RunnableTask(driver));
//        }
//
//        tasks.forEach(executorService::execute);
//


        // Teste das Programm auch einmal mit Strafe(n) für die Pole Position und einmal ohne. Was kannst du bei den verschiedenen Runs beobachten?.
        // erster immer laptime 0
        // wenn threadanzahl erhöht wird -> alle laptimes erhöhen sich


        // Kannst du nun feststellen wann alle Fahrer*innen ihre Runde beendet haben? Schreibe
        // deine Antwort als Kommentar in deinen Code.


        // Assignment 3

        ArrayList<CallableTask> tasks = new ArrayList<>();

        for (Driver driver : drivers) {
            tasks.add(new CallableTask(driver));
        }


        try {
            List<Future<Driver>> results = executorService.invokeAll(tasks);

            results.forEach(f -> {
                try {
                    System.out.println(f.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Methode aus. Experimentiere wieder mit einer unterschiedlichen Thread Anzahl (1-8) und Strafen
        // Können wir nun feststellen wann alle Fahrer*innen ihre Runde gefahren sind? Beschreibe deine Beobachtungen wiederum als Kommentar im Code
        // nein, da wenn alle threads fertig sind werden sie geprinted
        // bei höherer ThreadAnzahl -> time wird größer
        // bei höheren Strafen -> laptime wird größer, ist aber unterschiedlich



        executorService.shutdown();

    }

    private static void addPenalties(List<Driver> drivers) {
        Random random = new Random();
        for (Driver driver : drivers) {
            int randomPenalties = random.nextInt(20) + 5;
            for (int i = 0; i < randomPenalties; i++) {
                driver.addPenalty();
            }
        }
    }
}
