package com.darknessvenom.data_structure.impl.stack;

import com.darknessvenom.data_structure.DoubleLinkedListNode;
import com.darknessvenom.data_structure.interfaces.Stack;

import java.util.Iterator;

/**
 * <p>
 * Title:栈
 * </p>
 * <p>
 * Module:
 * </p>
 *
 * @author: DarknessVenom@gmail.com
 * @date: 4/13/21
 */
public class LinkedListStack<T> implements Stack<T> {

    /**
     * 指向后入栈的节点的指针
     */
    private DoubleLinkedListNode<T> top;

    private int size;

    public LinkedListStack() {}

    /**
     * P106 1.3.42
     * 栈的深拷贝
     * @param stack
     */
    public LinkedListStack(Stack<T> stack) {
        if (stack != null && !stack.isEmpty()) {
            int index = 0;
            int oldStackSize = stack.getSize();
            Object[] elements = new Object[oldStackSize];
            for (T t : stack) {
                elements[index++] = t;
            }

            for (int i = 0; i < oldStackSize; i++) {
                this.push((T)elements[i]);
            }
        }
    }

    @Override
    public void push(T t) {

        if (isEmpty()) {
            top = new DoubleLinkedListNode<>(t);
        } else {
            DoubleLinkedListNode<T> temp = top;
            top.nextNode = new DoubleLinkedListNode<>(t);
            top = top.nextNode;
            top.previousNode = temp;
        }

        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }

        T result = top.node;
        if (top.previousNode != null) {
            top = top.previousNode;
            top.nextNode = null;
        } else {
            top = null;
        }
        size--;

        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public T peek() {
        return isEmpty() ? null : top.node;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListStackIterator();
    }

    class LinkedListStackIterator implements Iterator<T> {

        DoubleLinkedListNode<T> temp = top;

        @Override
        public boolean hasNext() {
            return temp != null;
        }

        @Override
        public T next() {
            T node = temp.node;
            temp = temp.previousNode;
            return node;
        }
    }

    @Override
    public String toString() {
        Iterator<T> it = iterator();
        if (!it.hasNext()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            T t = it.next();
            sb.append(t == this ? "(this Collection)" : t);
            if (!it.hasNext()) {
                return sb.append(" <-- top").toString();
            }
            sb.append(" <-->").append(' ');
        }
    }
}
