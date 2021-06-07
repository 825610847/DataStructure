package com.darknessvenom.data_structure.queue;

import com.darknessvenom.data_structure.impl.queue.CircylarLinkedQueue;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 5/25/21
 */
public class TestCircylarLinkedQueue {

    public static void main(String[] args) {
        CircylarLinkedQueue<String> queue = new CircylarLinkedQueue<>();

        queue.enqueue("0");
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        queue.enqueue("6");

        System.out.println(queue.josephus(2));

    }
}
