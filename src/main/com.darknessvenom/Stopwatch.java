package com.darknessvenom;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 6/5/21
 */
public class Stopwatch {


    private final long start;

    public Stopwatch() {
        this.start = System.currentTimeMillis();
    }

    public double elpasedTime() {
        return System.currentTimeMillis() - start;
    }

    public double elpasedTimeInSecond() {
        return elpasedTime() / 1000.0;
    }

}
