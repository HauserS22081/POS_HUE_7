package net.htlgkr.pos.secondassignment;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Long> {

    private int upperBound;
    private int lowerBound;

    public CallableTask(int upperBound, int lowerBound) {
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
    }

    @Override
    public Long call() throws Exception {
        long sum = 0;
        for (int i = lowerBound; i < upperBound; i++) {
            sum += i;
        }

        return sum;
    }
}
