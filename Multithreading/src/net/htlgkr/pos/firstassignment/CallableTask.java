package net.htlgkr.pos.firstassignment;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Driver> {

    private Driver driver;

    public CallableTask(Driver driver) {
        this.driver = driver;
    }

    @Override
    public Driver call() throws Exception {
        driver.drive();
        return driver;
    }
}
