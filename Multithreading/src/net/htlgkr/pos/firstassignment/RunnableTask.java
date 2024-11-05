package net.htlgkr.pos.firstassignment;

public class RunnableTask implements Runnable {

    private final Driver driver;

    public RunnableTask(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void run() {
        driver.drive();
    }
}
