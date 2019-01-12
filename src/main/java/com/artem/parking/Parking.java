package com.artem.parking;

import com.artem.exception.PossibleException;

import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.LinkedList;


public class Parking<T> {
    private final static int POOL_SIZE = 5;
    private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
    private final Queue<T> resources = new LinkedList<T>();

    public Parking(Queue<T> source) {
        resources.addAll(source);
    }

    public T getResource(long maxWaitMillis) throws PossibleException {
        try {
            if (semaphore.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS)) {
                T res = resources.poll();
                return res;
            }
        } catch (InterruptedException e) {
            throw new PossibleException(e);
        }
        throw new PossibleException(":WAITING TIME IS LOST");
    }

    public void returnResource(T res) {
        resources.add(res);
        // освобождает место
        semaphore.release();

    }
}