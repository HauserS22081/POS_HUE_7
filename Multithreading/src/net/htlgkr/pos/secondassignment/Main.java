package net.htlgkr.pos.secondassignment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    private final static int NUMBER = 1000000;
    private final static int NUMBEROFTHREADS = 4;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBEROFTHREADS);


        List<CallableTask> tasks = new ArrayList<>();

        int lowerBound = 1;
        int upperBound = 1;
        int increasing = NUMBER / NUMBEROFTHREADS;

        for (int i = 0; i < NUMBEROFTHREADS; i++) {
            upperBound += increasing;

            tasks.add(new CallableTask(upperBound, lowerBound));

            lowerBound += increasing;
        }

        if (NUMBER % NUMBEROFTHREADS != 0) {
            tasks.add(new CallableTask(NUMBER, lowerBound));
        }


        long sum;
        try {
            List<Future<Long>> results = executorService.invokeAll(tasks);

            sum = results.stream().mapToLong(n -> {
                try {
                    return n.get();
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }).sum();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();

        System.out.println(sum);
    }
}
