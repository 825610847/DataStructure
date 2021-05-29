package com.darknessvenom.chapter;

import com.darknessvenom.data_structure.impl.stack.LinkedListStack;
import com.darknessvenom.data_structure.interfaces.Stack;
import com.sun.istack.internal.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 4/19/21
 */
public class Chapter_01 {

    /**
     * P102 1.3.4题
     *
     * @param s
     * @return
     */
    public static boolean parentheses(@NotNull String s) {

        Map<Character, Character> bracketsMap = new HashMap<>();
        bracketsMap.put(')', '(');
        bracketsMap.put(']', '[');
        bracketsMap.put('}', '{');

        Stack<Character> stack = new LinkedListStack<>();

        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else if (stack.isEmpty()) {
                return false;
            } else if (bracketsMap.containsKey(bracket)) {
                char top = stack.pop();
                if (top != bracketsMap.get(bracket)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * P102 1.3.9题
     *
     * @param expression
     * @return
     */
    public static String dijkstra_II(String expression) {
        if (expression == null || "".equals(expression)) {
            return null;
        }

        /**
         * 运算符栈
         */
        Stack<String> operators = new LinkedListStack<>();

        /**
         * 操作数栈
         */
        Stack<String> values = new LinkedListStack<>();

        Map<Character, String> bracketsMap = new HashMap<>();

        bracketsMap.put(')', "(");
        bracketsMap.put(']', "[");
        bracketsMap.put('}', "{");

        for (int i = 0; i < expression.length(); i++) {

            char c = expression.charAt(i);

            //如果是数字则压入操作数栈
            if (Character.isDigit(c)) {
                values.push("" + c);
            }
            //如果是运算符则压入运算符栈
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                operators.push("" + c);
            } else if (bracketsMap.containsKey(c)) {
                String val = values.pop();
                String op = operators.pop();
                values.push(bracketsMap.get(c) + values.pop() + op + val + c);
            }
        }

        return values.pop();
    }

    /**
     * P102 1.3.10题 <br/>
     * 中序表达式转前序表达式 <br/>
     * 例：2*3/(2-1)+3*(4-1) -> +/*23-21*3-41 <br/>
     * 参考：https://juejin.cn/post/6844903463667630087 <br/>
     *
     * @param expression
     * @return
     */
    public static String infixToReverse(String expression) throws Exception {
        return new StringBuilder(infixToPostfix(expression)).reverse().toString();
    }

    /**
     * P102 1.3.10题 <br/>
     * 中序表达式转后序表达式 <br/>
     * *****************************************************************************
     * Compilation:  javac InfixToPostfix.java
     * Execution:    java InfixToPostFix
     * Dependencies: Stack.java StdIn.java StdOut.java
     * <p>
     * Reads in a fully parenthesized infix expression from standard input
     * and prints an equivalent postfix expression to standard output.
     * <p>
     * Windows users: replace [Ctrl-d] with [Ctrl-z] to signify end of file.
     * <p>
     * % java InfixToPostfix
     * ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )
     * [Ctrl-d]
     * 2 3 4 + 5 6 * * +
     * <p>
     * % java InfixToPostfix
     * ( ( ( 5 + ( 7 * ( 1 + 1 ) ) ) * 3 ) + ( 2 * ( 1 + 1 ) ) )
     * 5 7 1 1 + * + 3 * 2 1 1 + * +
     * <p>
     * % java InfixToPostfix | java EvaluatePostfix
     * ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )
     * [Ctrl-d]
     * 212
     * <p>
     * 1、当输入的是操作数时候，直接输出 </br>
     * 2、当输入开括号时候，把它压栈 </br>
     * 3、当输入的是闭括号时候，先判断栈是否为空，若为空，
     * 则发生错误并进行相关处理。若非空，把栈中元素依次出栈输出，
     * 直到遇到第一个开括号，若没有遇到开括号，也发生错误，进行相关处理 </br>
     * 4、当输入是运算符op（+、- 、×、/）时候
     * a)循环，
     * 当（栈非空and栈顶不是开括号and栈顶运算符的优先级不低于输入的运算符的优先级）
     * 时，反复操作：将栈顶元素出栈输出 </br>
     * b)把输入的运算符op压栈5、当中序表达式的符号序列全部读入后，</br>
     * 若栈内仍有元素，把他们依次出栈输出。若弹出的元素遇到空括号，则说明不匹配，发生错误，并进行相关处理</br>
     * <p>
     * <p>
     * *****************************************************************************
     *
     * @param expression
     * @return
     */
    public static String infixToPostfix(String expression) throws Exception {
        if (expression == null || "".equals(expression)) {
            return null;
        }

        //存取运算符
        Stack<Character> stack = new LinkedListStack<>();

        int expLength = expression.length();

        char[] result = new char[expLength];
        Arrays.fill(result, ' ');

        int resultLength = 0;
        for (int i = 0; i < expLength; i++) {
            char index = expression.charAt(i);

            //操作数直接输出
            if (Character.isDigit(index)) {
                result[resultLength++] = index;
            } else if ('(' == index) {
                stack.push(index);
            } else if (')' == index) {
                while (!stack.isEmpty()) {
                    char top = stack.pop();
                    if (top == '(') {
                        break;
                    }
                    result[resultLength++] = top;
                }
            } else if (isOperator(index)) {
                while (!stack.isEmpty() && stack.peek() != '('
                        && precedenceJudge(stack.peek(), index)) {
                    result[resultLength++] = stack.pop();
                }
                stack.push(index);
            }

        }

        for (Character c : stack) {
            if ('(' == c) {
                throw new Exception("Empty bracket! ");
            }
            result[resultLength++] = c;
        }

        return String.valueOf(result).trim();
    }

    /**
     * 判断是否是加减乘除运算符
     * @param c
     * @return
     */
    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /**
     * @param x
     * @param y
     * @return x 优先级不低于 y
     */
    public static boolean precedenceJudge(char x, char y) {
        if (!isOperator(x) || !isOperator(y)) {
            return false;
        }

        if (x == '*' || x == '/') {
            return true;
        } else if (x == '+' || x == '-') {
            return y == '+' || y == '-';
        }
        return false;
    }

    /**
     * P102 1.3.11
     * 计算后续表达式
     *
     * @param postFix
     * @return
     */
    public static Double evaluatePostfix(String postFix) {
        if (postFix == null || postFix.length() <= 0) {
            return 0.0;
        }

        Stack<Double> stack = new LinkedListStack<>();

        for (int i = 0; i < postFix.length(); i++) {
            char index = postFix.charAt(i);
            if (Character.isDigit(index)) {
                stack.push(Double.parseDouble("" + index));
            } else {
                Double x = stack.pop();
                if('+' == index) {
                    stack.push(stack.pop() + x);
                }else if('-' == index) {
                    stack.push(stack.pop() - x);
                }else if('*' == index) {
                    stack.push(stack.pop() * x);
                }else if('/' == index) {
                    stack.push(stack.pop() / x);
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(evaluatePostfix(
                infixToPostfix("2*3/(2-1)+3*(4-1)")));
    }
}
