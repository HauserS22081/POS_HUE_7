package net.htlgkr.pos;

import java.util.Objects;

public class Driver {
    private String name;
    private String lastname;
    private String team;
    private int number;
    private long lapTime;
    private int penalties;
    private Formatter formatter;

    public Driver(String name, String lastname, String team, int number, Formatter formatter) {
        this.name = name;
        this.lastname = lastname;
        this.team = team;
        this.number = number;
        this.formatter = formatter;

        penalties = 0;
    }

    public void addPenalty() {
        penalties++;
    }

    public void drive() {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < penalties; i++) {
            for (int j = 0; j <= 1000000; j++) {

            }
        }

        lapTime = System.currentTimeMillis() - startTime;
    }

    @Override
    public String toString() {
        return formatter.format(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getLapTime() {
        return lapTime;
    }

    public void setLapTime(long lapTime) {
        this.lapTime = lapTime;
    }

    public int getPenalties() {
        return penalties;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver model = (Driver) o;
        return number == model.number && Float.compare(lapTime, model.lapTime) == 0 && penalties == model.penalties && Objects.equals(name, model.name) && Objects.equals(lastname, model.lastname) && Objects.equals(team, model.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, team, number, lapTime, penalties);
    }
}
