package com.darknessvenom.data_structure.queue;

import com.darknessvenom.data_structure.impl.queue.RandomQueue;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 5/30/21
 */
public class TestRandomQueue {

    public static void main(String[] args) {
        RandomQueue<String> queue = new RandomQueue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        queue.enqueue("f");
        queue.enqueue("g");
        queue.enqueue("h");
        queue.enqueue("i");
        queue.enqueue("j");
        queue.enqueue("k");

        System.out.println(queue);
        System.out.println(queue);
        System.out.println(queue);
        System.out.println(queue);
        System.out.println(queue);
        System.out.println(queue);
        System.out.println(queue);
        System.out.println(queue);
        System.out.println(queue);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}

