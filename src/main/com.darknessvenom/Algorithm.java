package com.darknessvenom;

import com.darknessvenom.data_structure.impl.stack.LinkedListStack;
import com.darknessvenom.data_structure.interfaces.Stack;
import com.sun.istack.internal.NotNull;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 4/11/21
 */
public class Algorithm {

    /**
     * 二分法（非递归）
     * @param inputArray
     * @param target
     * @param <T> 数字类型
     * @return
     */
    public static <T extends Number> int binarySearchByLoop(T[] inputArray, T target) {

        if(inputArray == null || target == null) {
            return -1;
        }

        if(inputArray.length <= 1) {
            return 0;
        }

        int lo = 0;

        int hi = inputArray.length - 1;

        int mid = 0;

        while(lo <= hi) {

            mid = (lo + hi) / 2;

            if(target.equals(inputArray[mid])) {
                return mid;
            }

            if(target.doubleValue() < inputArray[mid].doubleValue()) {

                hi = mid - 1;
            }else {

                lo = mid + 1;
            }

        }

        return -1;
    }

    /**
     * 二分查找（递归）
     * @param inputArray
     * @param target
     * @param <T>
     * @return
     */
    public static <T extends Number> int binarySearchByRecursion(T[] inputArray, T target) {
        if(inputArray == null || target == null) {
            return -1;
        }

        if(inputArray.length <= 1) {
            return 0;
        }

        return -1;
    }

    /**
     * Dijkstra双栈算术表达式求值算法
     * @param expression
     * @return
     */
    public static double dijkstra(@NotNull String expression) {

        /**
         * 运算符栈
         */
        Stack<Character> operators = new LinkedListStack<>();

        /**
         * 操作数栈
         */
        Stack<Double> values = new LinkedListStack<>();

        for(int i = 0; i < expression.length(); i++) {

            char c = expression.charAt(i);

            //如果是数字则压入操作数栈
            if(Character.isDigit(c)) {
               values.push(Double.parseDouble("" + c));
            }
            //如果是运算符则压入运算符栈
            else if (c == '+' || c == '-' || c == '*' || c == '/'){
               operators.push(c);
            }
            //如果是右括号，弹出一个运算符，弹出所需数量的操作数，并将运算符和操作数的运算结果压入操作数栈
            else if (c == ')') {
                char operator = operators.pop();
                double val = values.pop();
                if(operator == '+') {
                    val += values.pop();
                }else if(operator == '-') {
                    val -= values.pop();
                }else if(operator == '*') {
                    val *= values.pop();
                }else if(operator == '/') {
                    val /= values.pop();
                }
                values.push(val);
            }
        }

        return values.pop();
    }

}
