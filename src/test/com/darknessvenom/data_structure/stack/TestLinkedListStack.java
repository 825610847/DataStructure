package com.darknessvenom.data_structure.stack;

import com.darknessvenom.Stopwatch;
import com.darknessvenom.data_structure.impl.stack.LinkedListStack;
import com.darknessvenom.data_structure.interfaces.Stack;

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
public class TestLinkedListStack {

    public static void main(String[] args) {

        Stack<String> s1 = new LinkedListStack<>();
        s1.push("sss");
        s1.push("vvvv");
        s1.push("cccs");
        s1.push("bbbbb");
        s1.push("wesad");
        s1.push("w1ws");
        s1.push("wesx");
        s1.push("weasd");
        s1.push("sdw");

        Stopwatch timer = new Stopwatch();
        Stack<String> s2 = new LinkedListStack<>(s1);

        s1.pop();
        s1.pop();
        s1.pop();
        s1.pop();
        s1.pop();

        System.out.println(s2);
        System.out.println(timer.elpasedTime());

    }
}
